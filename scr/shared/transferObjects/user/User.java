package shared.transferObjects.user;

public abstract class User
{
  private String fName, lName, country, city, street;
  private int zip, phoneNo;
  private Password password;
  private Email email;

  public User(String fName, String lName, String country, String city,
      String street, int zip, int phoneNo, Password password, Email email)
  {
    this.fName = fName;
    this.lName = lName;
    this.country = country;
    this.city = city;
    this.street = street;
    this.zip = zip;
    this.phoneNo = phoneNo;
    this.password = password;
    this.email = email;
  }

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

  public String getCountry()
  {
    return country;
  }

  public void setCountry(String country)
  {
    this.country = country;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }

  public int getZip()
  {
    return zip;
  }

  public void setZip(int zip)
  {
    this.zip = zip;
  }

  public int getPhoneNo()
  {
    return phoneNo;
  }

  public void setPhoneNo(int phoneNo)
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
}
