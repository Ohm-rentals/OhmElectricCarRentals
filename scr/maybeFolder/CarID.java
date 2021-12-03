package maybeFolder;

import java.io.Serializable;
import java.util.Random;

public class CarID implements Serializable
{
  private String id;

  public CarID(){
    Random random= new Random();
    int number= random.nextInt(900)+100;
    id= "CAR"+number;
  }

  @Override public String toString()
  {
    return "CarID{" + "id='" + id + '\'' + '}';
  }
}
