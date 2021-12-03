package TESTING;

import shared.transferObjects.Address;
import shared.transferObjects.user.Customer;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

public class TestUser {
    private static User user;


   public static User user(Email email, Password password){
       Address address = new Address("Italy", "Genova", "Los Andes", "78", 1171);
       if (email.getEmail().equals("vlad@gmail.com") &&
               password.getPassword().equals("Simus123"))
       return new Customer("Vlad", "Rodriguez", address,6667733, password, email,4567,4545);
   return null;
   }
}
