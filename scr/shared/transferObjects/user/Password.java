package shared.transferObjects.user;

import java.io.Serializable;

public class Password implements Serializable
{
  private String password;

  public Password(String password)
  {
    this.password = password;
    if(!isValid()){
      throw  new IllegalArgumentException("password is not valid");
    }
  }


  public boolean isValid()
  {
    boolean hasDigits = false;
    for (char c : password.toCharArray())
    {
      if (Character.isDigit(c))
      {
        hasDigits = true;
      }
    }
    return password.length()>7 && hasDigits;
  }
}

