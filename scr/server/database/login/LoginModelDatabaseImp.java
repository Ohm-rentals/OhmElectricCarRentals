package server.database.login;

import server.database.DatabaseConnector;
import server.database.user.UserModelDatabase;
import server.database.user.UserModelDatabaseImpl;
import shared.transferObjects.user.*;

import java.sql.*;

public class LoginModelDatabaseImp implements LoginModelDatabase
{
  private final UserModelDatabase userModelDatabase = new UserModelDatabaseImpl();

  @Override public User login(Email email, Password password)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      LoginType loginType = getLoginType(email);
      Statement statement = connection.createStatement();

      String query =
          "SELECT password, " + setIdType(loginType) + " FROM \"OhmCarRental\"."
              + loginType + " WHERE email = '" + email.getEmail() + "';";

      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();
      String dbPassword = resultSet.getString("password");
      int id = resultSet.getInt(setIdType(loginType));
      if (dbPassword.equals(password.getPassword()))
      {
        System.out.println("Logged in");
        return userModelDatabase.getUserById(id, loginType);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  private LoginType getLoginType(Email email)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT type FROM \"OhmCarRental\".usertype WHERE email = ?"))
    {
      preparedStatement.setString(1, email.getEmail());
      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.next();
      String type = resultSet.getString("type");
      return setLoginType(type);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return LoginType.NO_ACCESS;
  }

  private LoginType setLoginType(String type)
  {
    if (type.equalsIgnoreCase("admin"))
    {
      return LoginType.ADMIN;
    }
    if (type.equalsIgnoreCase("front_desk"))
    {
      return LoginType.FRONT_DESK;
    }
    if (type.equalsIgnoreCase("customer"))
    {
      return LoginType.CUSTOMER;
    }
    else
    {
      System.out.println("Login Type did not match");
      return LoginType.NO_ACCESS;
    }
  }

  private String setIdType(LoginType loginType)
  {
    if (loginType.equals(LoginType.FRONT_DESK) || loginType.equals(
        LoginType.ADMIN))
    {
      return "emp_id";
    }
    else if (loginType.equals(LoginType.CUSTOMER))
    {
      return "customer_id";
    }
    return null;
  }
}
