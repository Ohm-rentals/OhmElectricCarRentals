package shared.transferObjects;

import maybeFolder.Date;
import maybeFolder.Time;

public class Other extends Status
{
  private String description;

  public Other(Date startDate, Date endDate, Time startTime, Time endTime,
      String description)
  {
    super(startDate, endDate, startTime, endTime);
    this.description = description;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
