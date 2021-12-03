package shared.transferObjects;

import maybeFolder.Date;
import maybeFolder.Time;

public class Cleaning extends Status
{
  public Cleaning(Date startDate, Date endDate, Time startTime, Time endTime)
  {
    super(startDate, endDate, startTime, endTime);
  }

}
