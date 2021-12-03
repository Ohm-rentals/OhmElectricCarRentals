package server.database.shared;

import server.database.DatabaseConnector;
import shared.transferObjects.Reservation;
import shared.transferObjects.user.Customer;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservationModelDatabaseImp implements ReservationModelDatabase
{
  @Override public ArrayList<Reservation> getAllReservations()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM reservation"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Reservation> reservations = new ArrayList<>();
      while (resultSet.next())
      {
        LocalDateTime start = LocalDateTime.of(
            resultSet.getDate("start_date").toLocalDate(),
            resultSet.getTime("start_time").toLocalTime());
        LocalDateTime end = LocalDateTime.of(
            resultSet.getDate("start_date").toLocalDate(),
            resultSet.getTime("start_time").toLocalTime());

        /*Statement statement = connection.createStatement(); // MAYBE DON'T NEED!!
        String query =  "SELECT * FROM customer WHERE customer_id = '" + resultSet.getString("customer_id") + "'";
        ResultSet resultSetCustomer = statement.executeQuery(query);
        Customer customer = new Customer(resultSetCustomer.getString("f_name"),resultSetCustomer.getString("l_name"))*/

        reservations.add(
            new Reservation(start, end, resultSet.getInt("km_start"),
                resultSet.getInt("km_end"), resultSet.getString("customer_id"),
                resultSet.getString("car_id")));
      }
      return reservations;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Reservation getReservationByReservationID(
      String reservationId)
  {
    try (Connection connection = DatabaseConnector.getInstance().getConnection())
    {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM reservation WHERE reservation_id = '" + reservationId + "'";
      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();

      LocalDateTime start = LocalDateTime.of(
          resultSet.getDate("start_date").toLocalDate(),
          resultSet.getTime("start_time").toLocalTime());
      LocalDateTime end = LocalDateTime.of(
          resultSet.getDate("start_date").toLocalDate(),
          resultSet.getTime("start_time").toLocalTime());

     return new Reservation(start, end, resultSet.getInt("km_start"),
        resultSet.getInt("km_end"), resultSet.getString("customer_id"),
        resultSet.getString("car_id"));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    return null;
  }

  @Override public ArrayList<Reservation> getAllCustomerReservations(
      String customerId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM reservation WHERE customer_id = '" + customerId + "'"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Reservation> reservations = new ArrayList<>();
      while (resultSet.next())
      {
        LocalDateTime start = LocalDateTime.of(
            resultSet.getDate("start_date").toLocalDate(),
            resultSet.getTime("start_time").toLocalTime());
        LocalDateTime end = LocalDateTime.of(
            resultSet.getDate("start_date").toLocalDate(),
            resultSet.getTime("start_time").toLocalTime());

        reservations.add(
            new Reservation(start, end, resultSet.getInt("km_start"),
                resultSet.getInt("km_end"), resultSet.getString("customer_id"),
                resultSet.getString("car_id")));
      }
      return reservations;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void deleteReservation(String reservationId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM reservations WHERE reservation_id = '" +reservationId+ "'"))
    {

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateReservation(String reservationId)
  {

  }

  @Override public void createReservation()
  {

  }

  private void customerPreparedStatement(PreparedStatement preparedStatement, Customer customer)
  {

  }
}
