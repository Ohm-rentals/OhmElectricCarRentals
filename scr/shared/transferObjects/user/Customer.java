package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class Customer extends User implements Serializable
{
  private int customerId;
  private String driverLicenseNo;

  public Customer(String fName, String lName, Address address, String phoneNo,
      Password password, Email email, String driverLicenseNo, int id)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
    this.customerId = id;
  }
  public Customer(String fName, String lName, Address address, String phoneNo,
      Password password, Email email, String driverLicenseNo)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
  }

  public int getCustomerId()
  {
    return customerId;
  }

  public String getDriverLicenseNo()
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
