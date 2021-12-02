package shared.transferObjects.user;

import maybeFolder.CustomerID;
import shared.transferObjects.Address;

import java.io.Serializable;

public class Customer extends User implements Serializable
{
  private int driverLicenseNo, id;

  public Customer(String fName, String lName, Address address, int phoneNo,
      Password password, Email email, int driverLicenseNo, int id)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
    this.id = id;
  }
  public Customer(String fName, String lName, Address address, int phoneNo,
      Password password, Email email, int driverLicenseNo)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
  }

  public int getId()
  {
    return id;
  }

  public int getDriverLicenseNo()
  {
    return driverLicenseNo;
  }

  @Override public String toString()
  {
    return "Customer{" + "driverLicenseNo=" + driverLicenseNo + ", id=" + id
        + '}';
  }
}
