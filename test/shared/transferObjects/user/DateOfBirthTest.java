package shared.transferObjects.user;

import org.junit.jupiter.api.Test;
import shared.transferObjects.Address;

import java.time.LocalDate;

public class DateOfBirthTest
{

  @Test public void validDate()
  {
    Admin admin = new Admin("bob", "oldenfull",
        new Address("denmark", "horsens", "beringvej", "1", 8700),
        new PhoneNo("12345678"), new Password("Bob12345"),
        new Email("bob.oldenuff@via.dk"), LocalDate.of(2001, 12, 20),
        new Ssn("1234567890"));
    
  }

}
