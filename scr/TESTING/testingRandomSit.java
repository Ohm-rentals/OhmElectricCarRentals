package TESTING;

import shared.transferObjects.PlateNo;
import shared.transferObjects.user.Password;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class testingRandomSit
{


  public static void main(String[] args)
  {
    PlateNo plateNo =new PlateNo("fg12545");
    System.out.println(plateNo.getPlate());

    LocalDate localDateBday= LocalDate.of(2001,12,20);
    Period period1= Period.between(localDateBday, LocalDate.now());
    System.out.println(period1.getYears());
  }
}
