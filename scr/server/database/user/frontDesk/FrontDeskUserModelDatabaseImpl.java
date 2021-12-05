package server.database.user.frontDesk;

import server.database.DatabaseConnector;
import shared.transferObjects.Address;
import shared.transferObjects.user.*;

import java.sql.*;
import java.util.ArrayList;

public class FrontDeskUserModelDatabaseImpl
    implements FrontDeskUserModelDatabase
{
  @Override public ArrayList<FrontDesk> getAllFrontDesk()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM front_desk"))
    {
      ArrayList<FrontDesk> frontDesks = new ArrayList<>();

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next())
      {
        Address address = new Address(resultSet.getString("country"),
            resultSet.getString("city"), resultSet.getString("street"),
            resultSet.getString("number"), resultSet.getInt("zip"));
        Address workAddress = new Address(
            resultSet.getString("workplace_country"),
            resultSet.getString("workplace_city"),
            resultSet.getString("workplace_street"),
            resultSet.getString("workplace_number"),
            resultSet.getInt("workplace_zip"));
        Password password = new Password(resultSet.getString("password"));
        Email email = new Email(resultSet.getString("email"));

        PhoneNo phoneNo = new PhoneNo(resultSet.getString("phone_no"));
        Ssn ssn = new Ssn(resultSet.getString("ssn"));
        frontDesks.add(new FrontDesk(resultSet.getString("f_name"),
            resultSet.getString("l_name"), address, phoneNo, password, email,
            ssn, workAddress, resultSet.getInt("emp_id")));
      }
      return frontDesks;
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public FrontDesk getFrontDeskById(int empId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query =
          "SELECT * FROM \"OhmCarRental\".front_desk WHERE emp_id = '" + empId
              + "'";

      ResultSet resultSet = statement.executeQuery(query);
      resultSet.next();
      Address address = new Address(resultSet.getString("country"),
          resultSet.getString("city"), resultSet.getString("street"),
          resultSet.getString("number"), resultSet.getInt("zip"));
      Address workAddress = new Address(
          resultSet.getString("workplace_country"),
          resultSet.getString("workplace_city"),
          resultSet.getString("workplace_street"),
          resultSet.getString("workplace_number"),
          resultSet.getInt("workplace_zip"));

      Password password = new Password(resultSet.getString("password"));
      Email email = new Email(resultSet.getString("email"));
      PhoneNo phoneNo = new PhoneNo(resultSet.getString("phone_no"));
      Ssn ssn = new Ssn(resultSet.getString("ssn"));
      return new FrontDesk(resultSet.getString("f_name"),
          resultSet.getString("l_name"), address, phoneNo, password, email, ssn,
          workAddress, resultSet.getInt("emp_id"));
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void createFrontDesk(FrontDesk frontDesk)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO \"OhmCarRental\".front_desk (f_name, l_name, phone_no, email, password, country, city,street, number, zip, ssn,workplace_country, workplace_city, workplace_street, workplace_number, workplace_zip) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"))
    {
      frontDeskPreparedStatement(preparedStatement, frontDesk);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateFrontDesk(FrontDesk frontDesk)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE \"OhmCarRental\".front_desk SET name = (?, ?), phone_no = ?, email = ?, password = ?,country=?, city=?,street=?,number=?, zip=?, ssn = ?,workplace_country=?, workplace_city=?,workplace_street=?,workplace_number=?, workplace_zip=? WHERE emp_id  = ?"))
    {
      frontDeskPreparedStatement(preparedStatement, frontDesk);
      preparedStatement.setInt(12, frontDesk.getEmpId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteFrontDesk(FrontDesk frontDesk)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM \"OhmCarRental\".front_desk WHERE emp_id = ?"))
    {
      preparedStatement.setInt(1, frontDesk.getEmpId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void frontDeskPreparedStatement(PreparedStatement preparedStatement,
      FrontDesk frontDesk)
  {
    try
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

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }
}
