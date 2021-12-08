package TESTING;

import shared.transferObjects.Address;
import shared.transferObjects.user.*;

import java.sql.Date;
import java.time.LocalDate;

public class TestUser {
    private static User user;


   public static User user(Email email, Password password){
       System.out.println(email.getEmail());
       System.out.println(password.getPassword());
       Address address = new Address("Italy", "Genova", "Los Andes", "78", 1171);





       System.out.println("Creados");

       if (email.getEmail().equals("vlad@gmail.com") && password.getPassword().equals("Simus123")) {
           Customer customer = new Customer("Vlad", "Rodriguez", address,new PhoneNo("12345678"), password, email, Date.valueOf(LocalDate.now().minusMonths(240)),new DriverLicense("78978372"));
           System.out.println("noooooooo");
           return customer;
       }

       if (email.getEmail().equals("simus@gmail.com") && password.getPassword().equals("Vlad1234")) {
           Admin admin = new Admin("Simus", "Lopez", address, new PhoneNo("12345678"), password, email, Date.valueOf(LocalDate.now().minusMonths(240)), new Ssn("9878245378"));
           System.out.println("yesss");
           return admin;

       }
   return null;
   }
}
