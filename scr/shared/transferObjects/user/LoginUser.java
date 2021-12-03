package shared.transferObjects.user;

public class LoginUser
{
  private Email email;
  private Password password;
  private LoginType loginType;

  public LoginUser(Email email, Password password, LoginType loginType)
  {
    this.email = email;
    this.password = password;
    this.loginType = loginType;
  }

  public String getEmail()
  {
    return email.getEmail();
  }

  public String getPassword()
  {
    return password.getPassword();
  }

  public LoginType getUserType()
  {
    return loginType;
  }
}
