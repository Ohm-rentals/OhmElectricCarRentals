package server.database.status.cleaning;

import server.database.DatabaseConnector;
import shared.transferObjects.Cleaning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                resultSet.getTimestamp("start_time"), resultSet.getTimestamp("end_time")));
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
    return null;
  }

  @Override public void createCleaning(int carId)
  {

  }

  @Override public void deleteCleaning(Cleaning cleaning)
  {

  }
}
