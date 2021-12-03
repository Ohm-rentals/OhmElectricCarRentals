package shared.transferObjects;

import java.sql.Timestamp;

public class Service extends Status
{
  private int km;

  public Service(int carId, int empId, Timestamp start, Timestamp end,int km)
  {
    super(carId, empId, start, end);
    this.km=km;
  }

  public int getKm()
  {
    return km;
  }

  public void setKm(int km)
  {
    this.km = km;
  }
}
