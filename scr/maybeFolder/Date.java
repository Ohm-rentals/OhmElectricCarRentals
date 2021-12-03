package maybeFolder;

import java.util.GregorianCalendar;

public class Date
{
  private  int day;
  private  int month;
  private  int year;

  public Date(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public Date()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    this.day = currentDate.get(GregorianCalendar.DATE);
    this.month = currentDate.get(GregorianCalendar.MONTH) + 1;
    this.year = currentDate.get(GregorianCalendar.YEAR);

  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }


  public static boolean isBefore(Date date1, Date date2)
  {

    if (date1.year < date2.year)
    {
      return true;
    }
    else if (date1.year == date2.year)
    {
      if (date1.month < date2.month)
      {
        return true;
      }
      else if (date1.month == date2.month)
      {
        if (date1.month < date2.day)
        {
          return true;
        }
      }
    }
    return false;
  }

  public static Date today()
  {
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    return new Date(currentDay, currentMonth, currentYear);
  }

  public Date copy()
  {
    return new Date(day, month, year);
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Date))
    {
      return false;
    }
    else
    {
      Date other = (Date) obj;
      return day == other.day && month == other.month && year == other.year;
    }
  }

  private boolean isLeapYear()
  {
    return ((this.year % 4 == 0) && (this.year % 100 != 0)) || (this.year % 400
        == 0);
  }

  private int daysInMonth()
  {
    if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
        || month == 10 || month == 12)
    {
      return 31;
    }
    else if (month == 4 || month == 6 || month == 9 || month == 11)
    {
      return 30;
    }
    else if (month == 2 && isLeapYear())
    {
      return 29;
    }
    else if (month == 2)
    {
      return 28;
    }
    else
    {
      return -1;
    }
  }

  public void nextDay()
  {
    if (this.day < daysInMonth())
    {
      this.day += 1;
    }
    else
    {
      this.day = 1;
      if (this.month < 12)
      {
        this.month += 1;
      }
      else
      {
        this.month = 1;
        this.year += 1;
      }
    }
  }
  public static int calculateDateRange(Date start, Date end){
    int count=0;
    Date startTemp= start.copy();
    while (startTemp.equals(end)){
      start.nextDay();
      count++;
    }
    return count;
  }

  public String toString()
  {
    return String.format("%02d/%02d/%04d", day, month, year);
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }
}
