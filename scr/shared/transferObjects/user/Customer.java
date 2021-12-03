package shared.transferObjects.user;

import shared.transferObjects.CustomerID;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Customer extends User implements Serializable
{
  private int driverLicenseNo;
  private CustomerID id;
  public Customer(String fName, String lName, String country, String city,
      String street, int zip, int phoneNo, Password password, Email email,
      int driverLicenseNo)
  {
    super(fName, lName, country, city, street, zip, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
    id= new CustomerID();
  }

  public int getDriverLicenseNo()
  {
    return driverLicenseNo;
  }

  public void setDriverLicenseNo(int driverLicenseNo)
  {
    this.driverLicenseNo = driverLicenseNo;
  }

  public CustomerID getCustomerId()
  {
    return id;
  }
}
