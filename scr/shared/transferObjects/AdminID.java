package shared.transferObjects;

import java.util.Random;

public class AdminID
{
  private  String id;
  public AdminID(){
    Random random= new Random();
    int number= random.nextInt(900)+100;
    id= "AA"+number;
  }

  @Override public String toString()
  {
    return "AdminID{" + "id='" + id + '\'' + '}';
  }
}
