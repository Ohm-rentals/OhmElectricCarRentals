package shared.transferObjects.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest
{
  @Test public void validPassword()
  {

    Password validPassword = new Password("Bob12345");

    assertTrue(Password.isValid(validPassword.getPassword()));
  }

  @Test public void passwordWithNoDigits()
  {
    try
    {
      Password noDigitPassword = new Password("BobIsCool");
      assertFalse(Password.isValid(noDigitPassword.getPassword()));
    }

    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void passwordWithNoUppercase()
  {
    try
    {
      Password noUppercasePassword = new Password("bob12345");
      assertFalse(Password.isValid(noUppercasePassword.getPassword()));
    }

    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }

  }

  @Test public void passwordWithNoLowercase()
  {
    try
    {
      Password noLowercasePassword = new Password("BOB12345");
      assertFalse(Password.isValid(noLowercasePassword.getPassword()));
    }

    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void passwordNotLongEnough()
  {
    try
    {
      Password shortPassword = new Password("Bob123");
      assertFalse(Password.isValid(shortPassword.getPassword()));
    }

    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }
}