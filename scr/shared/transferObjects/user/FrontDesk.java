package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class FrontDesk extends User implements Serializable
{
  private int ssn;
  private String id;

  public FrontDesk(String fName, String lName, Address address, int phoneNo,
      Password password, Email email, int ssn, String id)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.id = id;
    this.ssn = ssn;
  }

  public FrontDesk(String fName, String lName, Address address, int phoneNo,
      Password password, Email email)
  {
    super(fName, lName, address, phoneNo, password, email);
  }

  @Override
  public UserKind getKind() {
    return UserKind.FRONT_DESK;
  }

  public int getSsn()
  {
    return ssn;
  }

  public String getId()
  {
    return id;
  }

  @Override public String toString()
  {
    return "FrontDesk{" + "ssn=" + ssn + ", id='" + id + '\'' + '}';
  }
}

