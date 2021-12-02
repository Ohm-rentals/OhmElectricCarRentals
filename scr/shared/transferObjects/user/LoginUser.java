package shared.transferObjects.user;

public class LoginUser
{
  private Email email;
  private Password password;
  private UserType userType;

  public LoginUser(Email email, Password password, UserType userType)
  {
    this.email = email;
    this.password = password;
    this.userType = userType;
  }

  public Email getEmail()
  {
    return email;
  }

  public Password getPassword()
  {
    return password;
  }

  public UserType getUserType()
  {
    return userType;
  }
}
