package shared.transferObjects.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverLicenseTest
{
  @Test public void validPhoneNo()
  {
    DriverLicense DriverLicense = new DriverLicense("12345678");
    assertTrue(shared.transferObjects.user.DriverLicense.isValid(
        DriverLicense.getLicense()));
  }

  @Test public void shortPhoneNo()
  {
    try
    {
      DriverLicense shortPhoneNo = new DriverLicense("123543");
      assertFalse(DriverLicense.isValid(shortPhoneNo.getLicense()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void longPhoneNo()
  {
    try
    {
      DriverLicense longDriverLicense = new DriverLicense("1234567890");
      assertFalse(DriverLicense.isValid(longDriverLicense.getLicense()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void phoneNoContainsCharacters()
  {
    try
    {
      DriverLicense driverLicenseWithCharacter = new DriverLicense("DK123456");
      assertFalse(DriverLicense.isValid(driverLicenseWithCharacter.getLicense()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void phoneNumberInvalidFormat()
  {
    try
    {
      DriverLicense invalidFormatDriverLicense = new DriverLicense("123-456-78");
      assertFalse(DriverLicense.isValid(invalidFormatDriverLicense.getLicense()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

}