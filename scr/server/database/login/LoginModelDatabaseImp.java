package server.database.login;

import server.database.DatabaseConnector;
import shared.transferObjects.user.LoginUser;
import shared.transferObjects.user.LoginType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginModelDatabaseImp implements LoginModelDatabase
{

  @Override public LoginType login(LoginUser user)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query = "set search_path = \"OhmCarRental\"; SELECT password FROM " + user.getUserType().toString().toLowerCase()
          + " WHERE email = '" + user.getEmail() + "'";

      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();
      String dbPassword = resultSet.getString("password");

      if (dbPassword.equals(user.getPassword()))
      {
        return user.getUserType();
      }

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return LoginType.NO_ACCESS;
  }
}
