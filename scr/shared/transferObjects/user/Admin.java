package shared.transferObjects.user;

import maybeFolder.AdminID;

import java.io.Serializable;

public class Admin extends User implements Serializable
{
  private AdminID id;
  public Admin(String fName, String lName, String country, String city,
      String street, int zip, int phoneNo, Password password, Email email)
  {
    super(fName, lName, country, city, street, zip, phoneNo, password, email);

    id=new AdminID();
  }

  public AdminID getId()
  {
    return id;
  }
}
