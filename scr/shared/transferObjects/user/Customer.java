package shared.transferObjects.user;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Customer extends User implements Serializable
{
  private int driverLicenseNo, customerId;

  public Customer(String fName, String lName, String country, String city,
      String street, int zip, int phoneNo, Password password, Email email,
      int driverLicenseNo)
  {
    super(fName, lName, country, city, street, zip, phoneNo, password, email);
    this.driverLicenseNo = driverLicenseNo;
    this.customerId = ThreadLocalRandom.current().nextInt(999,9999+1);
  }

  public int getDriverLicenseNo()
  {
    return driverLicenseNo;
  }

  public void setDriverLicenseNo(int driverLicenseNo)
  {
    this.driverLicenseNo = driverLicenseNo;
  }

  public int getCustomerId()
  {
    return customerId;
  }
}
