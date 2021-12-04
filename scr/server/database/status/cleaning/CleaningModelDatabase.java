package server.database.status.cleaning;

import shared.transferObjects.Cleaning;

import java.util.ArrayList;

public interface CleaningModelDatabase
{

  ArrayList<Cleaning> getAllCleanings();
  ArrayList<Cleaning> getAllCleaningsFromACar(int carId);
  void createCleaning(Cleaning cleaning, int carId);
  void deleteCleaning(Cleaning cleaning);

}
