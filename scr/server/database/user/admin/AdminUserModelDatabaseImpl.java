package server.database.user.admin;

import server.database.DatabaseConnector;
import shared.transferObjects.Address;
import shared.transferObjects.Reservation;
import shared.transferObjects.user.Admin;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;

import java.sql.*;
import java.util.ArrayList;

public class AdminUserModelDatabaseImpl implements AdminUserModelDatabase
{

  @Override public ArrayList<Admin> getAllAdmins()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM admin"))
    {
      ArrayList<Admin> admins = new ArrayList<>();

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next())
      {
        Address address = new Address(resultSet.getString("country"),
            resultSet.getString("city"), resultSet.getString("street"),
            resultSet.getString("number"), resultSet.getInt("zip"));

        Password password = new Password(resultSet.getString("password"));
        Email email = new Email(resultSet.getString("email"));

        admins.add(new Admin(resultSet.getString("f_name"),
            resultSet.getString("l_name"), address,
            resultSet.getInt("phone_no"), password, email,
            resultSet.getString("emp_id")));
      }
      return admins;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public Admin getAdminById(int empId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query = "SELECT * FROM admin WHERE emp_id = '" + empId + "'";

      ResultSet resultSet = statement.executeQuery(query);

      Address address = new Address(resultSet.getString("country"),
          resultSet.getString("city"), resultSet.getString("street"),
          resultSet.getString("number"), resultSet.getInt("zip"));

      Password password = new Password(resultSet.getString("password"));
      Email email = new Email(resultSet.getString("email"));

      Admin admin = new Admin(resultSet.getString("f_name"),
          resultSet.getString("l_name"), address, resultSet.getInt("phone_no"),
          password, email, resultSet.getString("emp_id"));

      return admin;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void createAdmin(Admin admin)
  {

  }

  @Override public void updateAdmin(Admin admin)
  {

  }

  @Override public void deleteAdmin(Admin admin)
  {

  }

  private void adminPreparedStatement(PreparedStatement preparedStatement, Reservation reservation)
  {
//    preparedStatement.
  }

}
