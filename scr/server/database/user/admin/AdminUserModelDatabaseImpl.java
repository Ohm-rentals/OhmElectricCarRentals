package server.database.user.admin;

import server.database.DatabaseConnector;
import shared.transferObjects.Address;
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
            resultSet.getString("phone_no"), password, email,
            resultSet.getString("ssn"), resultSet.getInt("emp_id")));
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

      return new Admin(resultSet.getString("f_name"),
          resultSet.getString("l_name"), address,
          resultSet.getString("phone_no"), password, email,
          resultSet.getString("ssn"), resultSet.getInt("emp_id"));
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void createAdmin(Admin admin)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO admin (name, phone_no, email, password, address, ssn) VALUES ((?,?),?,?,?,(?,?,?,?,?),?)"))
    {
      adminPreparedStatement(preparedStatement, admin);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateAdmin(Admin admin)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE admin SET f_name = ?, l_name = ?, phone_no = ?, email = ?, password = ?, address.country = ?, address.city = ?, address.street = ?, address.number = ?, address.zip = ?, ssn = ? WHERE emp_id?"))
    {
      adminPreparedStatement(preparedStatement, admin);
      preparedStatement.setInt(12, admin.getEmpId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteAdmin(Admin admin)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM admin WHERE emp_id = ?"))
    {
      preparedStatement.setInt(1, admin.getEmpId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void adminPreparedStatement(PreparedStatement preparedStatement,
      Admin admin)
  {
    try
    {
      preparedStatement.setString(1, admin.getfName());
      preparedStatement.setString(2, admin.getlName());
      preparedStatement.setString(3, admin.getPhoneNo());
      preparedStatement.setString(4, admin.getEmail().getEmail());
      preparedStatement.setString(5, admin.getPassword().getPassword());
      preparedStatement.setString(6, admin.getAddress().getCountry());
      preparedStatement.setString(7, admin.getAddress().getCity());
      preparedStatement.setString(8, admin.getAddress().getStreet());
      preparedStatement.setString(9, admin.getAddress().getNumber());
      preparedStatement.setInt(10, admin.getAddress().getZip());
      preparedStatement.setString(11, admin.getSsn());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }

}
