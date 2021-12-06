package shared.transferObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateNoTest
{
  @Test public  void validPlateNo(){
    PlateNo plateNo= new PlateNo("AA12345");
    assertTrue(PlateNo.isValid(plateNo.getPlate()));
  }

  @Test public void validPlateNoWithLowercase(){
    PlateNo plateNoLowercase = new PlateNo("aa12345");
    assertTrue(PlateNo.isValid(plateNoLowercase.getPlate()));
  }

  @Test public  void plateNoWithBadFormatting(){
    try
    {
      PlateNo plateNoWithBadFormatting= new PlateNo("AA-233-44");
      assertFalse(PlateNo.isValid(plateNoWithBadFormatting.getPlate()));
    }
    catch (IllegalArgumentException e){
      System.out.println("exception caught");
    }
  }
  @Test public void plateNoWithNoNumbers(){
    try
    {
      PlateNo plateNoWithNoNumbers= new PlateNo("QWERTYU");
      assertFalse(PlateNo.isValid(plateNoWithNoNumbers.getPlate()));
    }
    catch (IllegalArgumentException e){
      System.out.println("exception caught");
    }
  }
  @Test public void plateNoWithNoLetters(){
    try
    {
      PlateNo plateNoWithNoLetters= new PlateNo("1234567");
      assertFalse(PlateNo.isValid(plateNoWithNoLetters.getPlate()));
    }
    catch (IllegalArgumentException e){
      System.out.println("exception caught");
    }
  }
  @Test public void plateWithMixedOrder(){
    try
    {
      PlateNo plateWithMixedOrder= new PlateNo("12SS123");
      assertFalse(PlateNo.isValid(plateWithMixedOrder.getPlate()));
    }
    catch (IllegalArgumentException e){
      System.out.println("exception caught");
    }
  }
}