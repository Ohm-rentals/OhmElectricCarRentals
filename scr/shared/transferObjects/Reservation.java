package shared.transferObjects;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reservation implements Serializable
{
  private LocalDateTime start, end;

  private String reservationId, customerId, carId;
  private int kmStart, kmEnd;

  public Reservation(LocalDateTime start, LocalDateTime end, int kmStart,
      int kmEnd, String customerId, String carId)
  {
    if (start.isBefore(end) && kmStart < kmEnd)
    {
      this.kmStart= kmStart;
      this.kmEnd = kmEnd;
      this.start = start;
      this.end = end;
      this.customerId = customerId;
      this.carId = carId;
    }
    else throw new IllegalArgumentException(
        "end date is before start or km start is bigger than km end");
  }

  public Reservation(LocalDateTime start, LocalDateTime end, int kmStart,
      int kmEnd, String customerId, String carId, String reservationId)
  {
    if (start.isBefore(end) && kmStart < kmEnd)
    {
      this.kmStart= kmStart;
      this.kmEnd = kmEnd;
      this.start = start;
      this.end = end;
      this.customerId = customerId;
      this.carId = carId;
      this.reservationId=reservationId;
    }
    else throw new IllegalArgumentException(
        "end date is before start or km start is bigger than km end");
  }

  public LocalDateTime getStart()
  {
    return start;
  }

  public void setStart(LocalDateTime start)
  {
    this.start = start;
  }

  public LocalDateTime getEnd()
  {
    return end;
  }

  public void setEnd(LocalDateTime end)
  {
    this.end = end;
  }

  public String getReservationId()
  {
    return reservationId;
  }

  public void setReservationId(String reservationId)
  {
    this.reservationId = reservationId;
  }

  public String getCustomerId()
  {
    return customerId;
  }

  public void setCustomerId(String customerId)
  {
    this.customerId = customerId;
  }

  public String getCarId()
  {
    return carId;
  }

  public void setCarId(String carId)
  {
    this.carId = carId;
  }

  public int getKmStart()
  {
    return kmStart;
  }

  public void setKmStart(int kmStart)
  {
    this.kmStart = kmStart;
  }

  public int getKmEnd()
  {
    return kmEnd;
  }

  public void setKmEnd(int kmEnd)
  {
    this.kmEnd = kmEnd;
  }

  @Override public String toString()
  {
    return "Reservation{" + "start=" + start + ", end=" + end + ", id='" + reservationId
        + '\'' + ", customerId='" + customerId + '\'' + ", carId='" + carId
        + '\'' + '}';
  }

  /*  public double calculateTotal()
  {
    return car.getPrice() * (int)Duration.between(start,end).toDays();
  }*/

}
