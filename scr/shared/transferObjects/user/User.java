package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;


public abstract class User implements Serializable
{
  private String fName, lName;
  private Password password;
  private Email email;
  private Address address;
  private PhoneNo phoneNo;
  private Date dob;

  public User(String fName, String lName, Address address, PhoneNo phoneNo,
      Password password, Email email, Date dob)
  {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.phoneNo = phoneNo;
    this.password = password;
    this.email = email;
    if (hasValidDob(dob.toLocalDate()))
    {
      this.dob = dob;
    }
    else
    {
      throw new IllegalArgumentException("age is not in range of 18-112");
    }
  }

  public abstract LoginType getType();

  public String getfName()
  {
    return fName;
  }

  public void setfName(String fName)
  {
    this.fName = fName;
  }

  public String getlName()
  {
    return lName;
  }

  public void setlName(String lName)
  {
    this.lName = lName;
  }

  public String getPhoneNo()
  {
    return phoneNo.getNumber();
  }

  public void setPhoneNo(String phoneNo)
  {
    this.phoneNo.setNumber(phoneNo);
  }

  public Password getPassword()
  {
    return password;
  }

  public void setPassword(Password password)
  {
    this.password = password;
  }

  public Email getEmail()
  {
    return email;
  }

  public void setEmail(Email email)
  {
    this.email = email;
  }

  public Address getAddress()
  {
    return address;
  }

  public void setAddress(Address address)
  {
    this.address = address;
  }

  public Date getDob()
  {
    return dob;
  }


  public String getDobAsString()
  {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    return formatter.format(dob);
  }

  private boolean hasValidDob(LocalDate dob)
  {
    Period period = Period.between(dob, LocalDate.now());
    if (period.getYears() < 18 || period.getYears() > 112)
    {
      return false;
    }
    return true;
  }

  @Override public String toString()
  {
    return "User{" + "fName='" + fName + '\'' + ", lName='" + lName + '\''
        + ", password=" + password + ", email=" + email + ", address=" + address
        + ", phoneNo=" + phoneNo + ", dob=" + dob + '}';
  }
}

