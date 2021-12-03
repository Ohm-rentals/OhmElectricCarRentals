package server.database;

import shared.transferObjects.Address;
import shared.transferObjects.Car;
import maybeFolder.Date;
import shared.transferObjects.LicenseNumber;
import shared.transferObjects.Parameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarModelDatabaseImp implements CarModelDatabase
{

  @Override public void storeCar(Car car)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO car (price, make, model, year, seats, type, range, km, no_plate, location, emp_id VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
    {
      setCarStatement(preparedStatement, car);

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  //loation type is set to address, database retrieves objrct
  @Override public void updateCar(String carId, Car car)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "UPDATE car SET price = ?, make = ?, model = ?, year = ?, seats = ?, type = ?, range = ?, km = ?, no_plate = ?, location = ? WHERE no_plate = ?"))
    {
      setCarStatement(preparedStatement, car);
      preparedStatement.setObject(10, car.getLicenseNumber());

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Car> getListCar()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM car"))
    {
      ResultSet r = preparedStatement.executeQuery();

      List<Car> result = new ArrayList<>();
      while (r.next())
      {
        result.add(new Car(r.getString("make"), r.getString("model"),
            r.getInt("price"), r.getDouble("price"), r.getString("type"),
            r.getInt("range"), r.getInt("km"),
            (Address) r.getObject("location"),
            (LicenseNumber) r.getObject("no_plate")));
      }

      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Car> getListCar(Parameters parameters)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM car WHERE price = ?, make = ?, model = ?, year = ?, seats = ?, type = ?, location = ?"))
    {
      preparedStatement.setDouble(1, parameters.getPrice());
      preparedStatement.setString(2, parameters.getMake());
      preparedStatement.setString(3, parameters.getModel());
      preparedStatement.setInt(4, parameters.getYear());
      preparedStatement.setInt(5, parameters.getSeats());
      preparedStatement.setString(6, parameters.getType());
      preparedStatement.setObject(7, parameters.getPickUpPoint());

      ResultSet r = preparedStatement.executeQuery();

      List<Car> result = new ArrayList<>();
      while (r.next())
      {
        result.add(
            new Car(r.getString("make"), r.getString("model"), r.getInt("year"),
                r.getDouble("price"), r.getString("type"), r.getInt("range"),
                r.getInt("km"), (Address) r.getObject("location"),
                (LicenseNumber) r.getObject("no_plate")));
      }

      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public boolean isAvailable(String carId, Date date)
  {
    return false;
  }

  @Override public void deleteCar(String carId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE * FROM car WHERE no_plate = ?"))
    {
      preparedStatement.setObject(1, carId);

      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  private void setCarStatement(PreparedStatement statement, Car car)
      throws SQLException
  {
    statement.setDouble(1, car.getPrice());
    statement.setString(2, car.getMake());
    statement.setString(3, car.getModel());
    statement.setInt(4, car.getYear());
    statement.setInt(5, car.getSeats());
    statement.setString(6, car.getType());
    statement.setInt(7, car.getRange());
    statement.setInt(8, car.getKm());
    statement.setString(9, car.getLicenseNumber());
  }
}
