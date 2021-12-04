package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public class Admin extends User implements Serializable
{
  private String ssn;
  private int empId;

  public Admin(String fName, String lName, Address address, String phoneNo,
      Password password, Email email, String ssn, int empId)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.ssn = ssn;
    this.empId = empId;
  }

  public Admin(String fName, String lName, Address address, String phoneNo,
      Password password, Email email, String ssn)
  {
    super(fName, lName, address, phoneNo, password, email);
    this.ssn = ssn;
  }

  public String getSsn()
  {
    return ssn;
  }

  public void setSsn(String snn)
  {
    this.ssn = snn;
  }

  public int getEmpId()
  {
    return empId;
  }

  @Override public String toString()
  {
    return "Admin{" + "ssn='" + ssn + '\'' + ", empId='" + empId + '\'' + '}';
  }

  @Override public LoginType getType()
  {
    return LoginType.ADMIN;}
}
