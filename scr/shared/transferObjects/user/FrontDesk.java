package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class FrontDesk extends User implements Serializable
{
  private int ssn, employeeID;

  public FrontDesk(String fName, String lName, Address address, int phoneNo,
      Password password, Email email, int ssn, int employeeID)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.employeeID = employeeID;
    this.ssn = ssn;
  }

  public FrontDesk(String fName, String lName, Address address, int phoneNo,
      Password password, Email email)
  {
    super(fName, lName, address, phoneNo, password, email);
  }

  public int getSsn()
  {
    return ssn;
  }

  public int getEmployeeID()
  {
    return employeeID;
  }

  @Override public String toString()
  {
    return "FrontDesk{" + "ssn=" + ssn + ", employeeID=" + employeeID + '}';
  }
}

