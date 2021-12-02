package shared.transferObjects;

import java.io.Serializable;

public class Parameters implements Serializable
{
  private String make, model, licenseNumber, type, licenseNo;
  private int year, seats, range, km;
  private double price;

  public Parameters(String make, String model, int year, double price, String type,
      int range)
  {
    this.make = make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.type = type;
    this.range = range;
  }
  public String getMake()
  {
    return make;
  }

  public String getModel()
  {
    return model;
  }

  public String getLicenseNumber()
  {
    return licenseNumber;
  }

  public String getType()
  {
    return type;
  }

  public int getYear()
  {
    return year;
  }

  public int getSeats()
  {
    return seats;
  }

  public double getPrice()
  {
    return price;
  }


}
