package TESTING;

import server.database.login.LoginModelDatabase;
import server.database.login.LoginModelDatabaseImp;
import server.database.user.admin.AdminUserModelDatabase;
import server.database.user.admin.AdminUserModelDatabaseImpl;
import shared.transferObjects.Address;
import shared.transferObjects.user.*;

import java.time.LocalDate;

public class DatabaseTEST
{
  public static void main(String[] args)
  {
    Address address = new Address("Denmark", "Horsens", "teknisk", "1",8700);
    System.out.println("Address has been made");

    Email email = new Email("simus@gmail.com");
    System.out.println("Email has been made");

    Password password = new Password("Vlad1234");
    System.out.println("Password has been made");

    PhoneNo phoneNo = new PhoneNo("11111111");

    Ssn ssn = new Ssn("0000000000");

    Admin simus = new Admin("Simus", "something",address,phoneNo,password,email,
        LocalDate.of(2000,1,1),ssn);

    System.out.println("Admin has been made");

   AdminUserModelDatabase adminUserModelDatabase = new AdminUserModelDatabaseImpl();
   adminUserModelDatabase.createAdmin(simus);



   LoginUser loginUser = new LoginUser(email,password);
    LoginModelDatabase loginModelDatabase = new LoginModelDatabaseImp();
    loginModelDatabase.login(loginUser);
    System.out.println("User login");
  }


}
