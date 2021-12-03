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
        reservations.add(new Reservation(resultSet.getTimestamp("start"),
            resultSet.getTimestamp("end"), resultSet.getInt("km_start"),
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
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();
      String query =
          "SELECT * FROM reservation WHERE reservation_id = '" + reservationId
              + "'";
      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();

      return new Reservation(resultSet.getTimestamp("start"),
          resultSet.getTimestamp("end"), resultSet.getInt("km_start"),
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
            "SELECT * FROM reservation WHERE customer_id = '" + customerId
                + "'"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Reservation> reservations = new ArrayList<>();
      while (resultSet.next())
      {

        reservations.add(new Reservation(resultSet.getTimestamp("start"),
            resultSet.getTimestamp("end"), resultSet.getInt("km_start"),
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
            "DELETE FROM reservations WHERE reservation_id = '" + reservationId
                + "'"))
    {
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateReservation(Reservation reservation)
  {
    try (Connection connection = DatabaseConnector.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE reservation SET startTime = ?, endTime = ?, km_start = ?, km_end = ?, customer_id = ?, car_id = ?"))
    {
      reservationPreparedStatement(preparedStatement,reservation);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void createReservation(Reservation reservation)
  {
    try (Connection connection = DatabaseConnector.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reservation (startTime, endTime, km_start, km_end, customer_id, car_id) VALUES (?,?,?,?,?,?"))
    {
      reservationPreparedStatement(preparedStatement,reservation);
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void reservationPreparedStatement(PreparedStatement preparedStatement,
      Reservation reservation)
  {
    try
    {
      preparedStatement.setTimestamp(1, reservation.getStart());
      preparedStatement.setTimestamp(2, reservation.getEnd());
      preparedStatement.setInt(3, reservation.getKmStart());
      preparedStatement.setInt(4, reservation.getKmEnd());
      preparedStatement.setString(5, reservation.getCustomerId());
      preparedStatement.setString(6, reservation.getCarId());
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
