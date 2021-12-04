package shared.transferObjects.user;

import shared.transferObjects.Address;

import java.io.Serializable;

public abstract class User implements Serializable
{
  private String fName, lName, phoneNo;
  private Password password;
  private Email email;
  private Address address;

  public User(String fName, String lName, Address address, String phoneNo,
      Password password, Email email)
  {
    this.fName = fName;
    this.lName = lName;
    this.address = address;
    this.phoneNo = phoneNo;
    this.password = password;
    this.email = email;
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
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo)
  {
    this.phoneNo = phoneNo;
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
}

