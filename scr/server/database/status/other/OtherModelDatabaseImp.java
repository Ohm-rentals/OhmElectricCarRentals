package server.database.status.other;

import server.database.DatabaseConnector;
import shared.transferObjects.Cleaning;
import shared.transferObjects.Other;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OtherModelDatabaseImp implements OtherModelDatabase
{
  @Override public ArrayList<Other> getAllOther()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM other"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Other> others = new ArrayList<>();
      while (resultSet.next())
      {
        others.add(
            new Other(resultSet.getInt("car_id"), resultSet.getInt("emp_id"),
                resultSet.getTimestamp("start_time"),
                resultSet.getTimestamp("end_time"),
                resultSet.getString("description")));
      }
      return others;
    }
    catch (SQLException e)

    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Other> greAllOtherForACar(int carId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM other  WHERE car_id='"+carId+"'"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Other> others = new ArrayList<>();
      while (resultSet.next())
      {
        others.add(
            new Other(resultSet.getInt("car_id"), resultSet.getInt("emp_id"),
                resultSet.getTimestamp("start_time"),
                resultSet.getTimestamp("end_time"),
                resultSet.getString("description")));
      }
      return others;
    }
    catch (SQLException e)

    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void createOther(Other other)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO other (start_time, end_time, emp_id, car_id, description) VALUES (?,?,?,?,?)");

      setOtherStatement(statement, other);
      statement.execute();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteOther(Other other)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE * FROM other WHERE emp_id='" + other.getEmpId()+"'"
                + "AND car_id='" + other.getCarId()+"'"))
    {
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void setOtherStatement(PreparedStatement statement, Other other)
  {
    try
    {
      statement.setTimestamp(1, other.getStart());
      statement.setTimestamp(2, other.getEnd());
      statement.setString(3, other.getDescription());
      statement.setInt(4, other.getEmpId());
      statement.setInt(5, other.getCarId());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
