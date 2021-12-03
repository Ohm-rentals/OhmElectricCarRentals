package shared.transferObjects;

import java.io.Serializable;
import java.util.Random;

public class ReservationID implements Serializable
{
  private String id;

  public ReservationID(){
    Random random= new Random();
    int number= random.nextInt(900)+100;
    this.id= "RES"+number;
  }

  @Override public String toString()
  {
    return "ReservationID{" + "id='" + id + '\'' + '}';
  }
}
