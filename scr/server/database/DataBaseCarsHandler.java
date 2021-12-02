package server.database;

import shared.transferObjects.Car;
import shared.transferObjects.Date;
import shared.transferObjects.Parameters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataBaseCarsHandler implements CarsData
{

  @Override public void storeCar(Car car)
  {
    try (Connection connection = DatabaseConnector.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO car (price, make, model, year, seats, type, range, km, no_plate, location, emp_id VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
    {
      preparedStatement.setDouble(1, car.getPrice());
      preparedStatement.setString(2, car.getMake());
      preparedStatement.setString(3, car.getModel());
      preparedStatement.setInt(4, car.getYear());
      preparedStatement.setInt(5, car.getSeats());
      preparedStatement.setString(6, car.getType());
      preparedStatement.setInt(7, car.getRange());
      preparedStatement.setInt(8, car.getKm());
      preparedStatement.setString(9, car.getLicenseNumber());


      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateCar(String carId, Car car)
  {

  }

  @Override public List<Car> getListCar()
  {
    try (Connection connection = DatabaseConnector.getInstance().getConnection();
        PreparedStatement preparedStatement = connection
            .prepareStatement("INSERT INTO car (price, make, model, year, seats, type, range, km, no_plate, location, emp_id VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
    {


      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Car> getListCar(Parameters parameters)
  {
    return null;
  }

  @Override public boolean isAvailable(String carId, Date date)
  {
    return false;
  }

  @Override public void deleteCar(String carId)
  {

  }
}
