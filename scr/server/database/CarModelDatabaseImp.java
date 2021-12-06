package server.database;

import shared.transferObjects.Address;
import shared.transferObjects.Car;
import maybeFolder.Date;
import shared.transferObjects.PlateNo;
import shared.transferObjects.Parameters;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarModelDatabaseImp implements CarModelDatabase
{

  @Override public ArrayList<Car> getAllCars()
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "SELECT * FROM \"OhmCarRental\".car"))
    {
      ArrayList<Car> cars = new ArrayList<>();

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next())
      {
        Address address = new Address(resultSet.getString("country"),
            resultSet.getString("city"), resultSet.getString("street"),
            resultSet.getString("number"), resultSet.getInt("zip"));

        PlateNo plateNo = new PlateNo(resultSet.getString("plate_no"));

        cars.add(
            new Car(resultSet.getString("make"), resultSet.getString("model"),
                resultSet.getInt("year"), resultSet.getDouble("price"),
                resultSet.getString("type"), resultSet.getInt("range"),
                resultSet.getInt("km"), address, plateNo));
      }

      return cars;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Car getCarById(int carId)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection())
    {
      Statement statement = connection.createStatement();

      String query =
          "SELECT * FROM \"OhmCarRental\".car WHERE car_id = '" + carId + "'";

      ResultSet resultSet = statement.executeQuery(query);

      resultSet.next();

      Address address = new Address(resultSet.getString("country"),
          resultSet.getString("city"), resultSet.getString("street"),
          resultSet.getString("number"), resultSet.getInt("zip"));

      PlateNo plateNo = new PlateNo(resultSet.getString("plate_no"));

      return new Car(resultSet.getString("make"), resultSet.getString("model"),
          resultSet.getInt("year"), resultSet.getDouble("price"),
          resultSet.getString("type"), resultSet.getInt("range"),
          resultSet.getInt("km"), address, plateNo);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override public void createCar(Car car)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "INSERT INTO \"OhmCarRental\".car (make, model, year, price, type, range, km, country, city, street, number, zip, plate_no) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"))
    {
      carPreparedStatement(preparedStatement,car);
      preparedStatement.execute();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void updateCar(Car car)
  {
    try(Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE \"OhmCarRental\".car SET make = ?, model = ?, year = ?, price = ?, type = ?, range = ?, km = ?, country = ?, city = ?, street = ?, number = ?, zip = ?, plate_no = ? WHERE car_id = ?"))
    {
      carPreparedStatement(preparedStatement,car);
      preparedStatement.setInt(14,car.getCarId());
      preparedStatement.execute();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  @Override public void deleteCar(Car car)
  {
    try (Connection connection = DatabaseConnector.getInstance()
        .getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
            "DELETE FROM \"OhmCarRental\".car WHERE car_id = ?"))
    {
      preparedStatement.setInt(1, car.getCarId());
      preparedStatement.execute();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

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
     // preparedStatement.setObject(10, car.getLicenseNumber());

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
            (PlateNo) r.getObject("no_plate")));
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
                (PlateNo) r.getObject("no_plate")));
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
   // statement.setString(9, car.getLicenseNumber());
  }

  private void carPreparedStatement(PreparedStatement preparedStatement, Car car)
  {
    try
    {
      preparedStatement.setString(1,car.getMake());
      preparedStatement.setString(2,car.getModel());
      preparedStatement.setInt(3,car.getYear());
      preparedStatement.setDouble(4,car.getPrice());
      preparedStatement.setString(5,car.getType());
      preparedStatement.setInt(6,car.getRange());
      preparedStatement.setInt(7,car.getKm());
      preparedStatement.setString(8,car.getPickupPoint().getCountry());
      preparedStatement.setString(9,car.getPickupPoint().getCity());
      preparedStatement.setString(10,car.getPickupPoint().getStreet());
      preparedStatement.setString(11,car.getPickupPoint().getNumber());
      preparedStatement.setInt(12,car.getPickupPoint().getZip());
      preparedStatement.setString(13,car.getPlateNo().getPlate());
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
