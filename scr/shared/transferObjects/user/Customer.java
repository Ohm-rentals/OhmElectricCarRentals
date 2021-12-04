package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class Customer extends User implements Serializable
{
  private int customerId;
  private DriverLicense driverLicenseNo;

  public Customer(String fName, String lName, Address address, PhoneNo phoneNo,
      Password password, Email email, DriverLicense driverLicenseNo, int id)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
    this.customerId = id;
  }
  public Customer(String fName, String lName, Address address, PhoneNo phoneNo,
      Password password, Email email, DriverLicense driverLicenseNo)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
  }

  public int getCustomerId()
  {
    return customerId;
  }

  public DriverLicense getDriverLicenseNo()
  {
    return driverLicenseNo;
  }

  @Override public String toString()
  {
    return "Customer{" + "customerId=" + customerId + ", driverLicenseNo='"
        + driverLicenseNo + '\'' + '}';
  }

  @Override public LoginType getType()
  {
    return LoginType.CUSTOMER;
  }
}
