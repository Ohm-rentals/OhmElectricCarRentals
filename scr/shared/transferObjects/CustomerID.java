package shared.transferObjects;

import java.io.Serializable;
import java.util.Random;

public class CustomerID implements Serializable
{
  private String id;

  public CustomerID(){
    Random random= new Random();
    int number= random.nextInt(900)+100;
    id= "CC"+number;
  }

  @Override public String toString()
  {
    return "CustomerID{" + "id='" + id + '\'' + '}';
  }

}
