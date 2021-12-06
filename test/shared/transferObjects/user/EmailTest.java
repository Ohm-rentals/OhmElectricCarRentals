package shared.transferObjects.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest
{
  @Test public void validEmail()
  {
    Email validEmail = new Email("bob@gmail.com");
    assertTrue(Email.isValid(validEmail.getEmail()));
  }

  @Test public void validEmailWithDot()
  {
    Email validEmailWithDot = new Email("bob.oldenuff@gmail.com");
    assertTrue(Email.isValid(validEmailWithDot.getEmail()));
  }

  @Test public void validEmailWithDifferentDomain()
  {
    Email validEmailWithDifferentDomain = new Email("bob.oldenuff@via.dk");
    assertTrue(Email.isValid(validEmailWithDifferentDomain.getEmail()));
  }

  @Test public void validEmailWithNumbers()
  {
    Email validEmailWithNumber = new Email("bob123@gmial.com");
    assertTrue(Email.isValid(validEmailWithNumber.getEmail()));
  }

  @Test public void validEmailWithCustomAddress()
  {
    Email validEmailWithCustomAddress = new Email(
        "bob.oldenuff@ohm.rentals.dk");
    assertTrue(Email.isValid(validEmailWithCustomAddress.getEmail()));
  }

  @Test public void validEmailWithUppercaseCharacters()
  {
    Email validEmailWithUppercaseCharacters = new Email(
        "Bob.Oldenuff@Ohm.Rentals.dk");
    assertTrue(Email.isValid(validEmailWithUppercaseCharacters.getEmail()));
  }

  @Test public void emailWithDoubleDomain()
  {

    Email emailWIthMultipleDomain = new Email("bob.oldenuff@gamil.dk.com");
    assertTrue(Email.isValid(emailWIthMultipleDomain.getEmail()));

  }

  @Test public void emailWithNoAddress()
  {
    try
    {
      Email emailWithNoAddress = new Email("bob.oldenuff");
      assertFalse(Email.isValid(emailWithNoAddress.getEmail()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void emailWithNoAtSign()
  {
    try
    {
      Email emailWithNoAtSign = new Email("bob.oldenuff.via.dk");
      assertFalse(Email.isValid(emailWithNoAtSign.getEmail()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void emailWithNoDomain()
  {
    try
    {
      Email emailWithNoDomain = new Email("bob.oldenuff@gmail");
      assertFalse(Email.isValid(emailWithNoDomain.getEmail()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void emailWithNoAddress2()
  {
    try
    {
      Email emailWithNoAddress = new Email("bob.oldenuff@com");
      assertFalse(Email.isValid(emailWithNoAddress.getEmail()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void emailWithLongDomain()
  {
    try
    {
      Email emailWithLongDomain = new Email("bob.oldenuff@gmail.copenhagen");
      assertFalse(Email.isValid(emailWithLongDomain.getEmail()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void emailWithDoubleAtSight()
  {
    try
    {
      Email emailWithDoubleAtSign = new Email("bob.oldenuff@@gmail.com");
      assertFalse(Email.isValid(emailWithDoubleAtSign.getEmail()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }
}