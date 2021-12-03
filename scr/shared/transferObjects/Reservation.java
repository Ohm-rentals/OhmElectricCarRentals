package shared.transferObjects;


import shared.transferObjects.user.Customer;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class Reservation implements Serializable
{
  private LocalDateTime start, end;

  private Car car;
  private Customer customer;
  private String id;

  public Reservation(LocalDateTime start, LocalDateTime end, Customer customer, Car car)
  {
    this.start = start;
    this.end = end;
    this.customer = customer;
    this.car = car;

    //if (!LocalDateTime.isBefore(start, end))
    if(!(start.isBefore(end)))
    {
      throw new IllegalArgumentException(
          "End date cannot be be before the start");
    }
  }

  public Reservation(LocalDateTime start, LocalDateTime end, Customer customer, Car car,
      String id)
  {
    this.start = start;
    this.end = end;
    this.customer = customer;
    this.car = car;
    this.id = id;

    if (!(start.isBefore(end)))
    {
      throw new IllegalArgumentException(
          "End date cannot be be before the start");
    }
  }

  public LocalDateTime getStart()
  {
    return start;
  }

  public void setStart(LocalDateTime start)
  {
    this.start = start;
  }

  public LocalDateTime getEnd()
  {
    return end;
  }

  public void setEnd(LocalDateTime end)
  {
    this.end = end;
  }

  public Car getCar()
  {
    return car;
  }

  public void setCar(Car car)
  {
    this.car = car;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
  }

  public String getId()
  {
    return id;
  }

  public double calculateTotal()
  {
    return car.getPrice() * (int)Duration.between(start,end).toDays();
  }

  @Override public String toString()
  {
    return "Reservation{" + "start=" + start + ", end=" + end + ", car=" + car
        + ", customer=" + customer + ", id='" + id + '\'' + '}';
  }
}
