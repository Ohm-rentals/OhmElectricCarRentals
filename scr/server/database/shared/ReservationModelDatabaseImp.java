package server.database.shared;

import server.database.DatabaseConnector;
import shared.transferObjects.Reservation;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReservationModelDatabaseImp implements ReservationModelDatabase
{
  @Override public ArrayList<Reservation> getAllReservations()
  {

    /*try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM  reservation"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Reservation> result = new ArrayList<>();
      while (resultSet.next())

      //  Date start= new Date(resultSet.getDate("start_date").getYear(),resultSet.);
      }
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    } return null;*/
    return null;
  }

  @Override public Reservation getReservationByReservationID(
      String reservationId)
  {
    return null;
  }

  @Override public ArrayList<Reservation> getAllCustomerReservations(
      String customerId)
  {
    return null;
  }

  @Override public void deleteReservation(String reservationId)
  {

  }

  @Override public void updateReservation(String reservationId)
  {

  }

  @Override public void createReservation()
  {

  }
}
