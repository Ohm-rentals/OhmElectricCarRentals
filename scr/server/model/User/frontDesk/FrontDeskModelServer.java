package server.model.user.frontDesk;

import shared.transferObjects.user.FrontDesk;

import java.util.ArrayList;

public interface FrontDeskModelServer
{
  ArrayList<FrontDesk> getAllFrontDesk();
  FrontDesk getFrontDeskById(int empId);
  void createFrontDesk(FrontDesk frontDesk);
  void updateFrontDesk(FrontDesk frontDesk);
  void deleteFrontDesk(FrontDesk frontDesk);
}
