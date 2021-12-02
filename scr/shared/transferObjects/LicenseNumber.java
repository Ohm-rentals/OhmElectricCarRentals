package shared.transferObjects;

import java.io.Serializable;
import java.util.regex.Pattern;

public class LicenseNumber implements Serializable
{
  String plate;

  public LicenseNumber(String plate){
    this.plate=plate;
    if(!isValid()){
      throw  new IllegalArgumentException("The number plate does not follow the pattern");
    }
  }
  private boolean isValid(){
    String licenseRegex= "A-Z"+"A-Z"+"0-9"+"0-9"+"0-9"+"0-9"+"0-9";
    Pattern pattern= Pattern.compile(licenseRegex);
    return pattern.matcher(plate).matches();
  }
}
