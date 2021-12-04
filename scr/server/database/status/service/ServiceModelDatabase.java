package server.database.status.service;

import shared.transferObjects.Service;

import java.util.ArrayList;

public interface ServiceModelDatabase
{
  ArrayList<Service> getAllServices();
  ArrayList<Service> getAllServicesFromACar(int carId);
  void createService(Service service);
  void deleteService(Service service);
}
