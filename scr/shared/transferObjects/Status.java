package shared.transferObjects;

import java.io.Serializable;

public abstract class Status implements Serializable
{
  private Date startDate, endDate;
  private Time startTime, endTime;

  public Status(Date startDate,Date endDate, Time startTime, Time endTime){
    this.startDate=startDate;
    this.endDate=endDate;
    this.startTime=startTime;
    this.endTime=endTime;
  }

  public  Date getEndDate()
  {
    return endDate;
  }

  public  Date getStartDate()
  {
    return startDate;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public  void setEndDate(Date endDate)
  {
    this.endDate = endDate;
  }

  public  void setEndTime(Time endTime)
  {
    this.endTime = endTime;
  }

  public  void setStartDate(Date startDate)
  {
    this.startDate = startDate;
  }

  public  void setStartTime(Time startTime)
  {
    this.startTime = startTime;
  }
}
