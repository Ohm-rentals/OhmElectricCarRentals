package shared.transferObjects;

public class Service extends Status
{
  private int km;

  public Service(Date startDate, Date endDate, Time startTime, Time endTime, int km)
  {
    super(startDate, endDate, startTime, endTime);
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
