package server.database.login;

import server.database.DatabaseConnector;
import shared.transferObjects.user.LoginUser;
import shared.transferObjects.user.LoginType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class   LoginModelDatabaseImp implements LoginModelDatabase
{

  @Override public LoginType login(LoginUser user)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query =
          "SELECT password, type FROM \"OhmCarRental\".usertype WHERE email = '"
              + user.getEmail() + "';";

      System.out.println("Database query---> " + query);
      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();

      System.out.println(
          "Database return<--- Password: " + resultSet.getString("password"));
      String dbPassword = resultSet.getString("password");

      if (dbPassword.equals(user.getPassword()))
      {
        System.out.println(
            "Database return<--- LoginType: " + resultSet.getString("type"));
        String loginType = resultSet.getString("type");
        return setLoginType(loginType);
      }

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    System.out.println(LoginType.NO_ACCESS + "Password did not match");
    return LoginType.NO_ACCESS;
  }

  private LoginType setLoginType(String type)
  {
    if (type.equalsIgnoreCase("admin"))
    {
      System.out.println("Logged in as Admin");
      return LoginType.ADMIN;
    }
    if (type.equalsIgnoreCase("front_desk"))
    {
      System.out.println("Logged in as Front desk");
      return LoginType.FRONT_DESK;
    }
    if (type.equalsIgnoreCase("customer"))
    {
      System.out.println("Logged in as Customer");
      return LoginType.CUSTOMER;
    }
    else
    {
      System.out.println("Login Type did not match");
      return LoginType.NO_ACCESS;
    }
  }
}
