package shared.transferObjects.user;

import java.io.Serializable;

public class Ssn implements Serializable
{
  private String ssn;

  public Ssn(String ssn)
  {
    if (isValid(ssn))
      throw new IllegalArgumentException(
          "ssn contains characters and/or is not 10 digits long");
    this.ssn = ssn;
  }

  public String getSsn()
  {
    return ssn;
  }

  public boolean isValid(String ssn)
  {
    for (char c : ssn.toCharArray())
    {
      if (!Character.isDigit(c))
      {
        return false;
      }
    }
    return ssn.length() == 9;
  }
}
