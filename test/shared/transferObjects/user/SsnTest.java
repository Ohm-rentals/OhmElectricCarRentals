package shared.transferObjects.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SsnTest
{

  @Test public void validSsn()
  {
    Ssn ssn = new Ssn("1234567890");
    assertTrue(Ssn.isValid(ssn.getSsn()));
  }

  @Test public void shortSsn()
  {
    try
    {
      Ssn shortSsn = new Ssn("1232353");
      assertFalse(Ssn.isValid(shortSsn.getSsn()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void ssnContainsCharacters()
  {
    try
    {
      Ssn ssnWithCharacters = new Ssn("123456hjk");
      assertFalse(Password.isValid(ssnWithCharacters.getSsn()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }

  @Test public void longSsn()
  {
    try
    {
      Ssn longSsn = new Ssn("1234567890123");
      assertFalse(Ssn.isValid(longSsn.getSsn()));
    }
    catch (IllegalArgumentException e)
    {
      System.out.println("exception caught");
    }
  }
}