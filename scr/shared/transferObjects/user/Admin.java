package shared.transferObjects.user;

import java.io.Serializable;

public class Admin extends User implements Serializable
{
  public Admin(String fName, String lName, String country, String city,
      String street, int zip, int phoneNo, Password password, Email email)
  {
    super(fName, lName, country, city, street, zip, phoneNo, password, email);
  }
}
