package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class FrontDesk extends User implements Serializable
{
  private int empId;
  private Ssn ssn;
  private Address workAddress;

  public FrontDesk(String fName, String lName, Address personalAddress, PhoneNo phoneNo,
      Password password, Email email, Date dob, Ssn ssn, Address workAddress, int empId)
  {
    super(fName, lName, personalAddress, phoneNo, password, email, dob);
    this.empId = empId;
    this.ssn = ssn;
    this.workAddress=workAddress;
  }

  public FrontDesk(String fName, String lName, Address personalAddress, PhoneNo phoneNo,
      Password password, Email email,Date dob, Ssn ssn, Address workAddress)
  {
    super(fName, lName, personalAddress, phoneNo, password, email, dob);
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

