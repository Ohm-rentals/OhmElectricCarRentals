package shared.transferObjects.user;

import java.io.Serializable;

public class Password implements Serializable
{
  private String password;

  public Password(String password)
  {
    if (isValid(password))
    {
      this.password = password;
    }
    else
      throw new IllegalArgumentException("password is not valid");
  }

  public String getPassword()
  {
    return password;
  }

  public boolean isValid(String password)
  {
    boolean hasDigits = false;
    for (char c : password.toCharArray())
    {
      if (Character.isDigit(c))
      {
        hasDigits = true;
      }
    }
    return password.length() > 7 && hasDigits;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Password other))
    {
      return false;
    }
    else
    {
      return password.equals(other.password);
    }
  }
}

