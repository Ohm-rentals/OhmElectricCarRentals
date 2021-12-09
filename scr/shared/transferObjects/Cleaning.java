package shared.transferObjects;

import java.sql.Timestamp;

public class Cleaning extends Status
{

  public Cleaning(int carId, int empId, Timestamp start, Timestamp end)
  {
    super(carId, empId, start, end);
  }
}
