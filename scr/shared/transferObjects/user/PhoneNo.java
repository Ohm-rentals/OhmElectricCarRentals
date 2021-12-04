package shared.transferObjects.user;

import java.io.Serializable;

public class PhoneNo implements Serializable
{
  private String number;

  public PhoneNo(String number){
    if(!isValid(number)) throw new IllegalArgumentException("The phone number contains characters and/or is not 8 digits long");
    this.number=number;
  }

  public String getNumber()
  {

    return number;
  }
  private boolean isValid(String number){
    for (char c:number.toCharArray())
    {
      if (!Character.isDigit(c))
      {
        return false;
      }
    }
    return number.length()==7;
  }
}
