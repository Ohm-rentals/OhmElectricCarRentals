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

    Admin simus = new Admin("Simus", "something",address,"8888888",password,email,"111111111");
    System.out.println("Admin has been made");


    AdminUserModelDatabase adminUserModelDatabase = new AdminUserModelDatabaseImpl();
    adminUserModelDatabase.createAdmin(simus);
    System.out.println("Admin added");

    LoginUser loginUser = new LoginUser(email,password, LoginType.ADMIN);
    LoginModelDatabase loginModelDatabase = new LoginModelDatabaseImp();
    loginModelDatabase.login(loginUser);
    System.out.println("User login");
  }


}
