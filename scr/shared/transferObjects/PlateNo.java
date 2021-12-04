package shared.transferObjects;

import java.io.Serializable;
import java.util.regex.Pattern;

public class PlateNo implements Serializable
{
  String plate;

  public PlateNo(String plate){

    if(!isValid(plate)){
      throw  new IllegalArgumentException("The number plate does not follow the pattern");
    }

    this.plate=plate.toUpperCase();
  }
  private boolean isValid(String plateNo){
    String licenseRegex= "[A-Za-z][A-Za-z][0-9][0-9][0-9][0-9][0-9]";
    Pattern pattern= Pattern.compile(licenseRegex);
    return pattern.matcher(plateNo).matches();
  }

  public String getPlate()
  {
    return plate;
  }
}
