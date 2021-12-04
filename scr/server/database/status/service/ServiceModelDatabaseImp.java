package server.database.status.service;

import server.database.DatabaseConnector;
import shared.transferObjects.Car;
import shared.transferObjects.Cleaning;
import shared.transferObjects.Service;

import java.sql.*;
import java.util.ArrayList;

public class ServiceModelDatabaseImp implements ServiceModelDatabase
{
  @Override public ArrayList<Service> getAllServices()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("SELECT * FROM service"))
    {
      ResultSet resultSet = preparedStatement.executeQuery();
      ArrayList<Service> services = new ArrayList<>();
      while (resultSet.next())
      {
        services.add(
            new Service(resultSet.getInt("car_id"), resultSet.getInt("emp_id"),
                resultSet.getTimestamp("start_time"),
                resultSet.getTimestamp("end_time"), resultSet.getInt("km")));
      }
      return services;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Service> getAllServicesFromACar(int carId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();
      String query = "SELECT * FROM service  WHERE car_id='" + carId + "'";
      ResultSet resultSet = statement.executeQuery(query);
      ArrayList<Service> services = new ArrayList<>();
      while (resultSet.next())
      {
        services.add(
            new Service(resultSet.getInt("car_id"), resultSet.getInt("emp_id"),
                resultSet.getTimestamp("start_time"),
                resultSet.getTimestamp("end_time"), resultSet.getInt("km")));
      }
      return services;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void createService(Service service)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO service (start_time, end_time,km, emp_id, car_id) VALUES (?,?,?,?,?)");

      setServiceStatement(statement, service);
      statement.execute();

    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteService(Service service)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE * FROM service WHERE emp_id='" + service.getEmpId()+"' "
                + "AND car_id='" + service.getCarId()+"'"))
    {
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void setServiceStatement(PreparedStatement statement, Service service)
  {
    try
    {
      statement.setTimestamp(1, service.getStart());
      statement.setTimestamp(2, service.getEnd());
      statement.setInt(3, service.getKm());
      statement.setInt(4, service.getEmpId());
      statement.setInt(5, service.getCarId());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
