package TESTING;

import shared.transferObjects.Address;
import shared.transferObjects.Car;
import shared.transferObjects.LicenseNumber;

import java.util.ArrayList;

public class CarList
{
  private ArrayList<Car> cars;
  private Address address = new Address("Denmark", "Aarhus", "Oddervej", "14",8000);
  private LicenseNumber licenseNumber = new LicenseNumber("CH 16786");
  private Car car0 = new Car("Tesla", "Model 3", 2020, 800, "Sedan", 550,20000,address,licenseNumber,"010501");
  private Car car1 = new Car("BMW", "i3", 2020, 350, "Hatch Back", 350,20000,address,licenseNumber,"010104");
  private Car car2 = new Car("Kia", "Niro", 2020, 200, "SUV", 200,20000,address,licenseNumber,"010109");
  private Car car3 = new Car("Volkswagen", "ID.3", 2020, 500, "Hatch back", 100,20000,address,licenseNumber,"310101");
  private Car car4 = new Car("Mercedes", "EQS", 2020, 600, "Sedan", 450,20000,address,licenseNumber,"010104");
  private Car car5 = new Car("Nissan", "LEAF", 2020, 275, "Sedan", 300,20000,address,licenseNumber,"010108");
  private Car car6 = new Car("Porsche", "Taycan 4S", 2020, 1500, "Coupe", 550,20000,address,licenseNumber,"110101");
  private Car car7 = new Car("Ford", "Mach-E", 2020, 520, "SUV", 400,20000,address,licenseNumber,"010501");
  private Car car8 = new Car("Tesla", "Model Y", 2020, 700, "SUV", 550,20000,address,licenseNumber,"050101");
  private Car car9 = new Car("Rivian", "R1T", 2020, 1000, "Pickup", 550,20000,address,licenseNumber,"510101");
  private Car car10 = new Car("Tesla", "Model s", 2020, 1200, "Sedan", 550,20000,address,licenseNumber,"210101");
  private Car car11 = new Car("Hyundai", "Ioniq", 2020, 300, "Sedan", 370,20000,address,licenseNumber,"060101");
  private Car car12 = new Car("MINI", "Cooper SE", 2020, 940, "Sedan", 550,20000,address,licenseNumber,"710101");
  private Car car13 = new Car("Hyundai", "Kona", 2020, 600, "Hatch Back", 550,20000,address,licenseNumber,"077101");
  private Car car14 = new Car("Tesla", "Model 3", 2020, 500, "Sedan", 550,20000,address,licenseNumber,"010188");

  public CarList()
  {
    this.cars = new ArrayList<>();
    cars.add(car0);
    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);
    cars.add(car5);
    cars.add(car6);
    cars.add(car7);
    cars.add(car8);
    cars.add(car9);
    cars.add(car10);
    cars.add(car11);
    cars.add(car12);
    cars.add(car13);
    cars.add(car14);
  }

  public void addCar(Car car)
  {
    cars.add(car);
  }

  public void removeCar(Car car)
  {
    if (!cars.isEmpty())
    {
      cars.remove(car);
    }
  }

  public void removeCar(int index)
  {
    if (!cars.isEmpty())
    {
      cars.remove(index);
    }
  }

  public Car getCar(int index)
  {
    return cars.get(index);
  }

  public int size()
  {
    return cars.size();
  }
}
