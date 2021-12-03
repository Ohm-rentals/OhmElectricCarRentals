package shared.transferObjects.user;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Email implements Serializable
{
  private String email;

  public Email(String email)
  {
    this.email = email;
  }

  public boolean isValid()
  {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
        + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

    Pattern pat = Pattern.compile(emailRegex);
    return pat.matcher(email).matches();
  }

  public String getEmail()
  {
    return email;
  }
}
