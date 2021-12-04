package server.database.status.other;

import shared.transferObjects.Other;

import java.util.ArrayList;

public interface OtherModelDatabase
{
  ArrayList<Other> getAllOther();
  ArrayList<Other> greAllOtherForACar(int carId);
  void createOther(Other other);
  void deleteOther(Other other);

}
