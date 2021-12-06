package shared.transferObjects.user;

public class LoginUser
{
  private Email email;
  private Password password;

  public LoginUser(Email email, Password password)
  {
    this.email = email;
    this.password = password;
  }

  public String getEmail()
  {
    return email.getEmail();
  }

  public String getPassword()
  {
    return password.getPassword();
  }
}
