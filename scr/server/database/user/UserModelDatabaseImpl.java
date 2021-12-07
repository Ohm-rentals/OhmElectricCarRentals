package server.database.user;

import server.database.DatabaseConnector;
import shared.transferObjects.Address;
import shared.transferObjects.user.*;

import java.sql.*;
import java.util.ArrayList;

public class UserModelDatabaseImpl implements UserModelDatabase
{
  public ArrayList<User> getUsersByType(LoginType loginType)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            queryAllUserByType(loginType)))
    {
      ArrayList<User> users = new ArrayList<>();

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next())
      {
        users.add(newUser(loginType, resultSet));
      }
      return users;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  public User getUserById(int id,LoginType loginType)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryGetUserById(loginType, id)))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      resultSet.next();

      return newUser(loginType, resultSet);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  public void createUser(User user)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            queryCreateUser(user)))
    {
      createUserExecute(user, preparedStatement);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public void updateUser(User user)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            queryUpdateUser(user)))
    {
      updateUserExecute(user, preparedStatement);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public void deleteUser(User user)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            queryDeleteUser(user)))
    {
      deleteUserExecute(user, preparedStatement);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private User newUser(LoginType loginType, ResultSet resultSet)
      throws SQLException
  {
    if (loginType.equals(LoginType.ADMIN))
    {
      return new Admin(getFirstName(resultSet), getLastName(resultSet),
          getAddress(resultSet), getPhoneNo(resultSet), getPassword(resultSet),
          getEmail(resultSet), getDob(resultSet), getSsn(resultSet),
          getEmpId(resultSet));
    }
    else if (loginType.equals(LoginType.CUSTOMER))
    {
      return new Customer(getFirstName(resultSet), getLastName(resultSet),
          getAddress(resultSet), getPhoneNo(resultSet), getPassword(resultSet),
          getEmail(resultSet), getDob(resultSet), getDriverLicense(resultSet),
          getCustomerId(resultSet));
    }
    else if (loginType.equals(LoginType.FRONT_DESK))
    {
      return new FrontDesk(getFirstName(resultSet), getLastName(resultSet),
          getAddress(resultSet), getPhoneNo(resultSet), getPassword(resultSet),
          getEmail(resultSet), getDob(resultSet), getSsn(resultSet),
          getWorkAddress(resultSet), getEmpId(resultSet));
    }
    return null;
  }

  private void createUserExecute(User user, PreparedStatement preparedStatement)
      throws SQLException
  {
    if (user.getType().equals(LoginType.ADMIN))
    {
      Admin admin = (Admin) user;
      adminPreparedStatement(preparedStatement, admin);
      preparedStatement.setString(13, admin.getType().toString());
      preparedStatement.execute();
    }
    else if (user.getType().equals(LoginType.CUSTOMER))
    {
      Customer customer = (Customer) user;
      customerPreparedStatement(preparedStatement, customer);
      preparedStatement.setString(13, customer.getType().toString());
      preparedStatement.execute();
    }
    else if (user.getType().equals(LoginType.FRONT_DESK))
    {
      FrontDesk frontDesk = (FrontDesk) user;
      frontDeskPreparedStatement(preparedStatement, frontDesk);
      preparedStatement.setString(18, frontDesk.getType().toString());
      preparedStatement.execute();
    }
  }

  private void updateUserExecute(User user, PreparedStatement preparedStatement)
      throws SQLException
  {
    if (user.getType().equals(LoginType.ADMIN))
    {
      Admin admin = (Admin) user;
      adminPreparedStatement(preparedStatement, admin);
      preparedStatement.setInt(13, admin.getEmpId());
      preparedStatement.execute();
    }
    else if (user.getType().equals(LoginType.CUSTOMER))
    {
      Customer customer = (Customer) user;
      customerPreparedStatement(preparedStatement, customer);
      preparedStatement.setInt(12, customer.getCustomerId());
      preparedStatement.execute();
    }
    else if (user.getType().equals(LoginType.FRONT_DESK))
    {
      FrontDesk frontDesk = (FrontDesk) user;
      frontDeskPreparedStatement(preparedStatement, frontDesk);
      preparedStatement.setInt(17, frontDesk.getEmpId());
      preparedStatement.execute();
    }
  }

  private void deleteUserExecute(User user, PreparedStatement preparedStatement)
      throws SQLException
  {
    if (user.getType().equals(LoginType.ADMIN))
    {
      Admin admin = (Admin) user;
      preparedStatement.setInt(1, admin.getEmpId());
      preparedStatement.execute();
    }
    else if (user.getType().equals(LoginType.CUSTOMER))
    {
      Customer customer = (Customer) user;
      preparedStatement.setInt(1, customer.getCustomerId());
      preparedStatement.execute();
    }
    else if (user.getType().equals(LoginType.FRONT_DESK))
    {
      FrontDesk frontDesk = (FrontDesk) user;
      preparedStatement.setInt(1, frontDesk.getEmpId());
      preparedStatement.execute();
    }
  }

  private String queryAllUserByType(LoginType loginType)
  {
    if (loginType.equals(LoginType.ADMIN))
    {
      return "SELECT * FROM \"OhmCarRental\".admin";
    }
    else if (loginType.equals(LoginType.CUSTOMER))
    {
      return "SELECT * FROM \"OhmCarRental\".customer";
    }
    else if (loginType.equals(LoginType.FRONT_DESK))
    {
      return "SELECT * FROM \"OhmCarRental\".front_desk";
    }
    return null;
  }

  private String queryGetUserById(LoginType loginType, int id)
  {
    if (loginType.equals(LoginType.ADMIN))
    {
      return "SELECT * FROM \"OhmCarRental\".admin WHERE emp_id = '" + id + "'";
    }
    else if (loginType.equals(LoginType.CUSTOMER))
    {
      return "SELECT * FROM \"OhmCarRental\".customer WHERE customer_id = '" + id + "'";
    }
    else if (loginType.equals(LoginType.FRONT_DESK))
    {
      return "SELECT * FROM \"OhmCarRental\".front_desk WHERE emp_id = '" + id
          + "'";
    }
    return null;
  }

  private String queryCreateUser(User user)
  {
    if (user.getType().equals(LoginType.ADMIN))
    {
      return "INSERT INTO \"OhmCarRental\".admin (f_name, l_name, phone_no, email, password, country, city, street, number, zip, ssn, dob, type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
    else if (user.getType().equals(LoginType.CUSTOMER))
    {
      return "INSERT INTO \"OhmCarRental\".customer (f_name, l_name, phone_no, email, password, country, city, street, number, zip, driver_license_no,dob, type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
    else if (user.getType().equals(LoginType.FRONT_DESK))
    {
      return "INSERT INTO \"OhmCarRental\".front_desk (f_name, l_name, phone_no, email, password, country, city, street, number, zip, ssn, workplace_country, workplace_city, workplace_street, workplace_number, workplace_zip, dob, type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }
    return null;
  }

  private String queryUpdateUser(User user)
  {
    if (user.getType().equals(LoginType.ADMIN))
    {
      return "UPDATE \"OhmCarRental\".admin SET f_name = ?, l_name = ?, phone_no = ?, email = ?, password = ?, country = ?, city = ?, street = ?, number = ?, zip = ?, ssn = ?, dob = ? WHERE emp_id = ?";
    }
    else if (user.getType().equals(LoginType.CUSTOMER))
    {
      return "UPDATE \"OhmCarRental\".customer SET f_name = ?, l_name = ?, phone_no = ?, email = ?, password = ?, country = ?, city = ?, street = ?, number = ?, zip = ?, driver_license_no = ? WHERE customer_id = ?";
    }
    else if (user.getType().equals(LoginType.FRONT_DESK))
    {
      return "UPDATE \"OhmCarRental\".front_desk SET name = f_name = ?, l_name = ?, phone_no = ?, email = ?, password = ?, country=?, city=?, street=?, number=?, zip=?, ssn = ?, workplace_country=?, workplace_city=?, workplace_street=?, workplace_number=?, workplace_zip=? WHERE emp_id  = ?";
    }
    return null;
  }

  private String queryDeleteUser(User user)
  {
    if (user.getType().equals(LoginType.ADMIN))
    {
      return "DELETE FROM \"OhmCarRental\".admin WHERE emp_id = ?";
    }
    else if (user.getType().equals(LoginType.CUSTOMER))
    {
      return "DELETE FROM \"OhmCarRental\".customer WHERE customer_id = ?";
    }
    else if (user.getType().equals(LoginType.FRONT_DESK))
    {
      return "DELETE FROM \"OhmCarRental\".front_desk WHERE emp_id = ?";
    }
    return null;
  }

  private void adminPreparedStatement(PreparedStatement preparedStatement,
      Admin admin) throws SQLException
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
    preparedStatement.setDate(12, admin.getDob());
  }

  private void customerPreparedStatement(PreparedStatement preparedStatement,
      Customer customer) throws SQLException
  {
    preparedStatement.setString(1, customer.getfName());
    preparedStatement.setString(2, customer.getlName());
    preparedStatement.setString(3, customer.getPhoneNo());
    preparedStatement.setString(4, customer.getEmail().getEmail());
    preparedStatement.setString(5, customer.getPassword().getPassword());
    preparedStatement.setString(6, customer.getAddress().getCountry());
    preparedStatement.setString(7, customer.getAddress().getCity());
    preparedStatement.setString(8, customer.getAddress().getStreet());
    preparedStatement.setString(9, customer.getAddress().getNumber());
    preparedStatement.setInt(10, customer.getAddress().getZip());
    preparedStatement.setString(11, customer.getDriverLicenseNo().getLicense());
    preparedStatement.setDate(12,customer.getDob());
  }

  private void frontDeskPreparedStatement(PreparedStatement preparedStatement,
      FrontDesk frontDesk) throws SQLException
  {
    preparedStatement.setString(1, frontDesk.getfName());
    preparedStatement.setString(2, frontDesk.getlName());
    preparedStatement.setString(3, frontDesk.getPhoneNo());
    preparedStatement.setString(4, frontDesk.getEmail().getEmail());
    preparedStatement.setString(5, frontDesk.getPassword().getPassword());
    preparedStatement.setString(6, frontDesk.getAddress().getCountry());
    preparedStatement.setString(7, frontDesk.getAddress().getCity());
    preparedStatement.setString(8, frontDesk.getAddress().getStreet());
    preparedStatement.setString(9, frontDesk.getAddress().getNumber());
    preparedStatement.setInt(10, frontDesk.getAddress().getZip());
    preparedStatement.setString(11, frontDesk.getSsn().getSsn());
    preparedStatement.setString(12, frontDesk.getWorkAddress().getCountry());
    preparedStatement.setString(13, frontDesk.getWorkAddress().getCity());
    preparedStatement.setString(14, frontDesk.getWorkAddress().getStreet());
    preparedStatement.setString(15, frontDesk.getWorkAddress().getNumber());
    preparedStatement.setInt(16, frontDesk.getWorkAddress().getZip());
    preparedStatement.setDate(17,frontDesk.getDob());
  }

  private Address getAddress(ResultSet resultSet) throws SQLException
  {
    return new Address(resultSet.getString("country"),
        resultSet.getString("city"), resultSet.getString("street"),
        resultSet.getString("number"), resultSet.getInt("zip"));
  }

  private Address getWorkAddress(ResultSet resultSet) throws SQLException
  {
    return new Address(resultSet.getString("workplace_country"),
        resultSet.getString("workplace_city"),
        resultSet.getString("workplace_street"),
        resultSet.getString("workplace_number"),
        resultSet.getInt("workplace_zip"));
  }

  private Password getPassword(ResultSet resultSet) throws SQLException
  {
    return new Password(resultSet.getString("password"));
  }

  private Email getEmail(ResultSet resultSet) throws SQLException
  {
    return new Email(resultSet.getString("email"));
  }

  private PhoneNo getPhoneNo(ResultSet resultSet) throws SQLException
  {
    return new PhoneNo(resultSet.getString("phone_no"));
  }

  private Ssn getSsn(ResultSet resultSet) throws SQLException
  {
    return new Ssn(resultSet.getString("ssn"));
  }

  private String getFirstName(ResultSet resultSet) throws SQLException
  {
    return resultSet.getString("f_name");
  }

  private String getLastName(ResultSet resultSet) throws SQLException
  {
    return resultSet.getString("l_name");
  }

  private Date getDob(ResultSet resultSet) throws SQLException
  {
    return resultSet.getDate("dob");
  }

  private int getEmpId(ResultSet resultSet) throws SQLException
  {
    return resultSet.getInt("emp_id");
  }

  private DriverLicense getDriverLicense(ResultSet resultSet)
      throws SQLException
  {
    return new DriverLicense(resultSet.getString("driver_license_no"));
  }

  private int getCustomerId(ResultSet resultSet) throws SQLException
  {
    return resultSet.getInt("customer_id");
  }
}
