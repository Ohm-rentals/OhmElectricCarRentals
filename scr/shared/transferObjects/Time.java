package shared.transferObjects;

import java.io.Serializable;

public class Time implements Serializable
{
  private int hour, minute;

  public Time(int hour, int minute){
    this.hour=hour;
    this.minute=minute;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public int getHour()
  {
    return hour;
  }

  public int getMinute()
  {
    return minute;
  }
}
