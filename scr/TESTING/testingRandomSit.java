package TESTING;

import shared.transferObjects.PlateNo;
import shared.transferObjects.user.Password;

public class testingRandomSit
{


  public static void main(String[] args)
  {
    PlateNo plateNo =new PlateNo("fg12545");
    System.out.println(plateNo.getPlate());

    Password password= new Password("12345678S");
    System.out.println(password);

  }
}
