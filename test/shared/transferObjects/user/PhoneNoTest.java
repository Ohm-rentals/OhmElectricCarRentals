package shared.transferObjects.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNoTest
{
  @Test public void validPhoneNo()
  {
    PhoneNo phoneNo = new PhoneNo("12345678");
    assertTrue(PhoneNo.isValid(phoneNo.getNumber()));
  }

  @Test public void shortPhoneNo()
  {
    try
    {
      PhoneNo shortPhoneNo = new PhoneNo("123543");
      assertFalse(PhoneNo.isValid(shortPhoneNo.getNumber()));
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
      PhoneNo longPhoneNo = new PhoneNo("1234567890");
      assertFalse(PhoneNo.isValid(longPhoneNo.getNumber()));
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
      PhoneNo phoneNoWithCharacter = new PhoneNo("DK123456");
      assertFalse(PhoneNo.isValid(phoneNoWithCharacter.getNumber()));
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
      PhoneNo invalidFormatPhoneNo = new PhoneNo("123-456-78");
      assertFalse(PhoneNo.isValid(invalidFormatPhoneNo.getNumber()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }
}