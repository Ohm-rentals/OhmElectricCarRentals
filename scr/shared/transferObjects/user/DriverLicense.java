package shared.transferObjects.user;

import java.io.Serializable;

public class DriverLicense implements Serializable
{
  private String licence;

  public DriverLicense(String licence){
    if(!isValid(licence)) throw new IllegalArgumentException("The license number contains characters and/or is not 8 digits long");

    this.licence=licence;
  }

  public String getLicence()
  {
    return licence;
  }
  public boolean isValid(String license)
  {
    for (char c : license.toCharArray())
    {
      if (!Character.isDigit(c))
      {
        return false;
      }
    }
    return license.length() == 7;
  }}
