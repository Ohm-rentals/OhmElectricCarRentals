package TESTING;

import server.database.login.LoginModelDatabase;
import server.database.login.LoginModelDatabaseImp;
import server.database.user.admin.AdminUserModelDatabase;
import server.database.user.admin.AdminUserModelDatabaseImpl;
import shared.transferObjects.Address;
import shared.transferObjects.user.*;

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

    Admin simus = new Admin("Simus", "something",address,phoneNo,password,email,ssn);
    System.out.println("Admin has been made");

    Email email2 = new Email("Vlad@gmail.com");

    Ssn ssn2 = new Ssn("00000000");

    Admin vlad = new Admin("Vlad", "Lazar", address, phoneNo,password,email2,ssn2);


   AdminUserModelDatabase adminUserModelDatabase = new AdminUserModelDatabaseImpl();
  //adminUserModelDatabase.createAdmin(simus);
   // adminUserModelDatabase.createAdmin(vlad);
    System.out.println("Admin added");

    Admin vlad2 = new Admin("Vlad", "Lazar", address, phoneNo,password,email,ssn2,3003);

    adminUserModelDatabase.updateAdmin(vlad2);

 /*   System.out.println(adminUserModelDatabase.getAllAdmins());
    System.out.println(adminUserModelDatabase.getAdminById(3005));
    System.out.println("1");
    adminUserModelDatabase.deleteAdmin(adminUserModelDatabase.getAdminById(3005));
    System.out.println("2");
    System.out.println(adminUserModelDatabase.getAllAdmins());
    System.out.println("3");*/


/*    LoginUser loginUser = new LoginUser(email,password, LoginType.ADMIN);
    LoginModelDatabase loginModelDatabase = new LoginModelDatabaseImp();
    loginModelDatabase.login(loginUser);
    System.out.println("User login");*/
  }


}
