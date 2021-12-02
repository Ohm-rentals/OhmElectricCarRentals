package server.database.login;

import server.database.DatabaseConnector;
import shared.transferObjects.user.LoginUser;
import shared.transferObjects.user.UserType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModelDatabaseImp implements LoginModelDatabase
{

  @Override public UserType login(LoginUser user)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query = "SELECT PASSWORD FROM " + user.getUserType().toString()
          + " WHERE EMAIL = '" + user.getEmail() + "'";

      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();
      String dBPassword = resultSet.getString("Password");

      if (dBPassword.equals(user.getPassword()))
      {
        return user.getUserType();
      }

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return UserType.NO_ACCESS;
  }
}
