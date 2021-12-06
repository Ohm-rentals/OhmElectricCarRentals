package server.model.user.frontDesk;

import shared.transferObjects.user.FrontDesk;

import java.util.ArrayList;

public class FrontDeskModelServerImpl implements FrontDeskModelServer
{
  private FrontDeskModelServer frontDeskModelServer;

  public FrontDeskModelServerImpl()
  {
    this.frontDeskModelServer = new FrontDeskModelServerImpl();
  }

  @Override public ArrayList<FrontDesk> getAllFrontDesk()
  {
    return frontDeskModelServer.getAllFrontDesk();
  }

  @Override public FrontDesk getFrontDeskById(int empId)
  {
    return frontDeskModelServer.getFrontDeskById(empId);
  }

  @Override public void createFrontDesk(FrontDesk frontDesk)
  {
    frontDeskModelServer.createFrontDesk(frontDesk);
  }

  @Override public void updateFrontDesk(FrontDesk frontDesk)
  {
    frontDeskModelServer.updateFrontDesk(frontDesk);
  }

  @Override public void deleteFrontDesk(FrontDesk frontDesk)
  {
    frontDeskModelServer.deleteFrontDesk(frontDesk);
  }
}
