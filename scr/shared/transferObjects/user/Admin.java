package shared.transferObjects.user;

import maybeFolder.AdminID;
import shared.transferObjects.Address;

import java.io.Serializable;

public class Admin extends User implements Serializable
{
  private String id;

  public Admin(String fName, String lName, Address address, int phoneNo,
      Password password, Email email, String id)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.id = id;
  }

  public Admin(String fName, String lName, Address address, int phoneNo,
      Password password, Email email)
  {
    super(fName, lName, address, phoneNo, password, email);

  }

  public String getId()
  {
    return id;
  }

  @Override public String toString()
  {
    return "Admin{" + "id='" + id + '\'' + '}';
  }
}
