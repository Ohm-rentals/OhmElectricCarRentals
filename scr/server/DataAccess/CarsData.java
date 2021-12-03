package server.DataAccess;

import shared.transferObjects.Car;

import java.util.Date;
import java.util.List;

public interface CarsData {
    void storeCar(Car car);
    void updateCar(String carId, Car car);
    List<Car> getListCar();
   // List<Car> getListCar(Parameters parameters) FOr Later
    boolean isAvailable(String carId, Date from, Date to);
    void deleteCar(String carId);
}
