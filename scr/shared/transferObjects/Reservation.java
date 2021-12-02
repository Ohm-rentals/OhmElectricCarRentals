package shared.transferObjects;

import maybeFolder.ReservationID;
import shared.transferObjects.user.Customer;

import java.io.Serializable;

public class Reservation implements Serializable
{
  private Date start, end;
  private Car car;
  private Customer customer;
  private String id;

  public Reservation(Date start, Date end, Customer customer, Car car)
  {
    this.start = start;
    this.end = end;
    this.customer = customer;
    this.car = car;

    if (!Date.isBefore(start, end))
    {
      throw new IllegalArgumentException(
          "End date cannot be be before the start");
    }
  }

  public Reservation(Date start, Date end, Customer customer, Car car,
      String id)
  {
    this.start = start;
    this.end = end;
    this.customer = customer;
    this.car = car;
    this.id = id;

    if (!Date.isBefore(start, end))
    {
      throw new IllegalArgumentException(
          "End date cannot be be before the start");
    }
  }

  public Date getStart()
  {
    return start;
  }

  public void setStart(Date start)
  {
    this.start = start;
  }

  public Date getEnd()
  {
    return end;
  }

  public void setEnd(Date end)
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

  public String  getId()
  {
    return id;
  }

  public double calculateTotal()
  {
    return car.getPrice() * Date.calculateDateRange(start, end);
  }

  @Override public String toString()
  {
    return "Reservation{" + "start=" + start + ", end=" + end + ", car=" + car
        + ", customer=" + customer + ", id='" + id + '\'' + '}';
  }
}
