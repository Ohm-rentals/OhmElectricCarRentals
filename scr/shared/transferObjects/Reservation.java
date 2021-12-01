package shared.transferObjects;

import shared.transferObjects.user.Customer;

import java.io.Serializable;

public class Reservation implements Serializable
{
  private Date start, end;
  private Car car;
  private Customer customer;
  private String id;

  public Reservation(Date start, Date end, Customer customer, Car car,
      String id)
  {
    this.start = start;
    this.end = end;
    this.customer = customer;
    this.car = car;
    this.id = id;
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

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public double calculateTotal(){
    return car.getPrice()*Date.calculateDateRange(start, end);
  }
}
