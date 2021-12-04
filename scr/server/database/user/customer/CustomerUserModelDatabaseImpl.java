package server.database.user.customer;

import server.database.DatabaseConnector;
import shared.transferObjects.Address;
import shared.transferObjects.user.Customer;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;

import java.sql.*;
import java.util.ArrayList;

public class CustomerUserModelDatabaseImpl implements CustomerUserModelDatabase
{
  @Override public ArrayList<Customer> getAllCustomers()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM customer"))
    {
      ArrayList<Customer> customers = new ArrayList<>();

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next())
      {
        Address address = new Address(resultSet.getString("country"),
            resultSet.getString("city"), resultSet.getString("street"),
            resultSet.getString("number"), resultSet.getInt("zip"));

        Password password = new Password(resultSet.getString("password"));
        Email email = new Email(resultSet.getString("email"));

        customers.add(new Customer(resultSet.getString("name.f_name"),
            resultSet.getString("name.l_name"), address,
            resultSet.getString("phone_no"), password, email,
            resultSet.getString("driver_license_no"),
            resultSet.getInt("customer_id")));
      }
      return customers;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public Customer getCustomerById(int customerId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query =
          "SELECT * FROM customer WHERE emp_id = '" + customerId + "'";

      ResultSet resultSet = statement.executeQuery(query);

      Address address = new Address(resultSet.getString("country"),
          resultSet.getString("city"), resultSet.getString("street"),
          resultSet.getString("number"), resultSet.getInt("zip"));

      Password password = new Password(resultSet.getString("password"));
      Email email = new Email(resultSet.getString("email"));

      return new Customer(resultSet.getString("name.f_name"),
          resultSet.getString("name.l_name"), address,
          resultSet.getString("phone_no"), password, email,
          resultSet.getString("driver_license_no"),
          resultSet.getInt("customer_id"));
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void createCustomer(Customer customer)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO customer (f_name, l_name, phone_no, email, password, address.country, address.city, address.street, address.number, address.zip, driver_license_no) VALUES (?,?,?,?,?,?,?,?,?,?)"))
    {
      customerPreparedStatement(preparedStatement, customer);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateCustomer(Customer customer)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE customer SET f_name = ?, l_name = ?, phone_no = ?, email = ?, password = ?, address.country = ?, address.city = ?, address.street = ?, address.number = ?, address.zip = ?, driver_license_no = ? WHERE customer_id?"))
    {
      customerPreparedStatement(preparedStatement, customer);
      preparedStatement.setInt(12, customer.getCustomerId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteCustomer(Customer customer)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM customer WHERE customer_id = ?"))
    {
      preparedStatement.setInt(1, customer.getCustomerId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void customerPreparedStatement(PreparedStatement preparedStatement,
      Customer customer)
  {
    try
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
      preparedStatement.setString(11, customer.getDriverLicenseNo());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
