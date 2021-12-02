package shared.transferObjects;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Car implements Serializable
{
  private String make, model, licenseNumber, type, pickUpPoint;
  private LicenseNumber licenseNo;
  private int year, seats, range, km;
  private double price;
  private CarID id;

  public Car(String make, String model, int year, double price, String type,
      int range, int km, String pickUpPoint, LicenseNumber licenseNo)
  {
    this.make = make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.type = type;
    this.range = range;
    this.km = km;
    this.pickUpPoint = pickUpPoint;
    this.licenseNo = licenseNo;
    id = new CarID();

  }

  public String getMake()
  {
    return make;
  }

  public void setMake(String make)
  {
    this.make = make;
  }

  public String getModel()
  {
    return model;
  }

  public void setModel(String model)
  {
    this.model = model;
  }

  public String getLicenseNumber()
  {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber)
  {
    this.licenseNumber = licenseNumber;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public int getSeats()
  {
    return seats;
  }

  public void setSeats(int seats)
  {
    this.seats = seats;
  }

  public int getRange()
  {
    return range;
  }

  public void setRange(int range)
  {
    this.range = range;
  }

  public int getKm()
  {
    return km;
  }

  public void setKm(int km)
  {
    this.km = km;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public CarID getId()
  {
    return id;
  }

  public void setPickUpPoint(String pickUpPoint) { this.pickUpPoint = pickUpPoint; }

  public String getPickUpPoint() { return pickUpPoint; }

  public void setLicenseNo(String licenseNo)
  {
    this.licenseNo = new LicenseNumber(licenseNo);
  }

  public LicenseNumber getLicenseNo()
  {
    return licenseNo;
  }

  @Override public String toString()
  {
    return "Car{" + "make='" + make + '\'' + ", model='" + model + '\''
        + ", licenseNumber='" + licenseNumber + '\'' + ", type='" + type + '\''
        + ", licenseNo='" + licenseNo + '\'' + ", year=" + year + ", seats="
        + seats + ", range=" + range + ", km=" + km + ", price=" + price
        + ", id=" + id + '}';
  }
}
