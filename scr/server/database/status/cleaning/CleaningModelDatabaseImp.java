package server.database.status.cleaning;

import client.model.personal.status.Stat;
import server.database.DatabaseConnector;
import shared.transferObjects.Cleaning;

import java.sql.*;
import java.util.ArrayList;

public class CleaningModelDatabaseImp implements CleaningModelDatabase
{
  @Override public ArrayList<Cleaning> getAllCleanings()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM cleaning"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Cleaning> cleanings = new ArrayList<>();
      while (resultSet.next())
      {
        cleanings.add(
            new Cleaning(resultSet.getInt("car_id"), resultSet.getInt("emp_id"),
                resultSet.getTimestamp("start_time"),
                resultSet.getTimestamp("end_time")));
      }
      return cleanings;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Cleaning> getAllCleaningsFromACar(int carId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM cleaning  WHERE car_id='" + carId + "'";
      ResultSet resultSet = statement.executeQuery(query);
      ArrayList<Cleaning> cleanings = new ArrayList<>();
      while (resultSet.next())
      {
        cleanings.add(
            new Cleaning(resultSet.getInt("car_id"), resultSet.getInt("emp_id"),
                resultSet.getTimestamp("start_time"),
                resultSet.getTimestamp("end_time")));
      }
      return cleanings;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void createCleaning(Cleaning cleaning, int carId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO car (start_time, end_time, emp_id, car_id) VALUES (?,?,?,?)");

      setCleaningStatement(statement, cleaning);
      statement.execute();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteCleaning(Cleaning cleaning)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE * FROM cleaning WHERE emp_id=" + cleaning.getEmpId()
                + "AND car_id=" + cleaning.getCarId()))
    {
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void setCleaningStatement(PreparedStatement statement,
      Cleaning cleaning)
  {
    try
    {
      statement.setTimestamp(1, cleaning.getStart());
      statement.setTimestamp(2, cleaning.getEnd());
      statement.setInt(3, cleaning.getEmpId());
      statement.setInt(4, cleaning.getCarId());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
