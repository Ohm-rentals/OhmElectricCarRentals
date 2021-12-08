package TESTING;

import server.database.login.LoginModelDatabase;
import server.database.login.LoginModelDatabaseImp;
import server.database.user.UserModelDatabase;
import server.database.user.UserModelDatabaseImpl;
import shared.transferObjects.Address;
import shared.transferObjects.user.*;

import java.sql.Date;

public class DatabaseTEST
{
  public static void main(String[] args)
  {

    Date date1 = new Date(95, 12, 18);
    Date date2 = new Date(99, 1, 15);
    Date date3 = new Date(80, 8, 22);
    Date date4 = new Date(93, 10, 1);

    Address address1 = new Address("Denmark", "Horsens", "teknisk", "1", 8700);
    Address address2 = new Address("Denmark", "Aarhus", "oddervej", "1", 8000);
    Address address3 = new Address("Denmark", "København", "teknisk", "1",
        2100);
    Address address4 = new Address("Denmark", "Juelsminde", "teknisk", "1",
        7130);

    Email email1 = new Email("simus@gmail.com");
    Email email2 = new Email("vlad@gmail.com");
    Email email3 = new Email("alfonso@gmail.com");
    Email email4 = new Email("Christopher@gmail.com");

    Password password1 = new Password("Vlad1234");
    Password password2 = new Password("Simus1234");
    Password password3 = new Password("Christopher1234");
    Password password4 = new Password("Alfonso1234");

    PhoneNo phoneNo1 = new PhoneNo("11111111");
    PhoneNo phoneNo2 = new PhoneNo("22222222");
    PhoneNo phoneNo3 = new PhoneNo("33333333");
    PhoneNo phoneNo4 = new PhoneNo("44444444");

    Ssn ssn1 = new Ssn("1111111111");
    Ssn ssn2 = new Ssn("2222222222");
    Ssn ssn3 = new Ssn("3333333333");
    Ssn ssn4 = new Ssn("4444444444");

    DriverLicense driverLicense = new DriverLicense("00000000");

    Admin simus = new Admin("Simus", "something", address1, phoneNo1, password1,
        email1, date1, ssn1);

    Admin christopher = new Admin("Christopher", "Gadgaard", address2, phoneNo2,
        password2, email2, date2, ssn2);

    Customer vlad = new Customer("Vlad", "Lazar", address3, phoneNo3, password3,
        email3, date3, driverLicense);

    FrontDesk alfonso = new FrontDesk("Alfonso", "Ridao", address4, phoneNo4,
        password4, email4, date4, ssn4, address1);

    UserModelDatabase userModelDatabase = new UserModelDatabaseImpl();

   /* userModelDatabase.createUser(simus);
    System.out.println("Simus created");
    userModelDatabase.createUser(christopher);
    System.out.println("Christopher created");
    userModelDatabase.createUser(vlad);
    System.out.println("Vlad created");
    userModelDatabase.createUser(alfonso);
    System.out.println("Alfonso created");*/

    System.out.println(userModelDatabase.getUsersByType(LoginType.ADMIN));
    System.out.println(userModelDatabase.getUsersByType(LoginType.CUSTOMER));
    System.out.println(userModelDatabase.getUsersByType(LoginType.FRONT_DESK));

    System.out.println(userModelDatabase.getUserById(3002,LoginType.ADMIN));
    System.out.println(userModelDatabase.getUserById(4001,LoginType.CUSTOMER));
    System.out.println(userModelDatabase.getUserById(5001,LoginType.FRONT_DESK));

    LoginModelDatabase loginModelDatabase = new LoginModelDatabaseImp();



    System.out.println(loginModelDatabase.login(email1,password1));
  }
}
