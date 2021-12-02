package server.database;

import shared.transferObjects.Car;
import shared.transferObjects.Date;
import shared.transferObjects.Parameters;

import java.util.List;

public interface CarsData
{
  void storeCar(Car car);
  void updateCar(String carId, Car car);
  List<Car> getListCar();
  List<Car> getListCar(Parameters parameters);
  boolean isAvailable(String carId, Date date);
  void deleteCar(String carId);
}
