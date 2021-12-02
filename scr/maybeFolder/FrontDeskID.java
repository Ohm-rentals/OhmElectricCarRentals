package maybeFolder;

import java.io.Serializable;
import java.util.Random;

public class FrontDeskID implements Serializable
{
  String id;

  public FrontDeskID(){
    Random random= new Random();
    int number= random.nextInt(900)+100;
    id= "FD"+number;
  }

  @Override public String toString()
  {
    return "FrontDeskID{" + "id='" + id + '\'' + '}';
  }
}
