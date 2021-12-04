package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class FrontDesk extends User implements Serializable
{
  private int empId;
  private Ssn ssn;

  public FrontDesk(String fName, String lName, Address address, PhoneNo phoneNo,
      Password password, Email email, Ssn ssn, int empId)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.empId = empId;
    this.ssn = ssn;
  }

  public FrontDesk(String fName, String lName, Address address, PhoneNo phoneNo,
      Password password, Email email, String snn)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.ssn = ssn;
  }

  public int getEmpId()
  {
    return empId;
  }

  public Ssn getSsn()
  {
    return ssn;
  }


  @Override public String toString()
  {
    return "FrontDesk{" + "empId=" + empId + ", ssn='" + ssn + '\'' + '}';
  }

  @Override public LoginType getType()
  {
    return LoginType.FRONT_DESK;
  }
}

