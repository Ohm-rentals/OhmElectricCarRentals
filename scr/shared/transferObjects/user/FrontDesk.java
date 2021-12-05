package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class FrontDesk extends User implements Serializable
{
  private int empId;
  private Ssn ssn;
  private Address workAddress;

  public FrontDesk(String fName, String lName, Address personalAddress, PhoneNo phoneNo,
      Password password, Email email, Ssn ssn, Address workAddress, int empId)
  {
    super(fName, lName, personalAddress, phoneNo, password, email);
    this.empId = empId;
    this.ssn = ssn;
    this.workAddress=workAddress;
  }

  public FrontDesk(String fName, String lName, Address personalAddress, PhoneNo phoneNo,
      Password password, Email email, String snn, Address workAddress)
  {
    super(fName, lName, personalAddress, phoneNo, password, email);
    this.ssn = ssn;
    this.workAddress=workAddress;
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

  public Address getWorkAddress(){
    return workAddress;
  }
}

