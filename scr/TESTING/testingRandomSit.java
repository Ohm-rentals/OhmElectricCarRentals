package TESTING;

import shared.transferObjects.PlateNo;
import shared.transferObjects.user.DriverLicense;
import shared.transferObjects.user.Email;

public class testingRandomSit
{


  public static void main(String[] args)
  {
    PlateNo plateNo =new PlateNo("fg12545");
    System.out.println(plateNo.getPlate());

    DriverLicense driverLicense = new DriverLicense("01234567");
    System.out.println(driverLicense.getLicence());

    Email email = new Email("test@gmail.com");
    System.out.println(email.getEmail());

  }
}
