package server.model.login;

import server.database.login.LoginModelDatabase;
import server.database.login.LoginModelDatabaseImp;
import shared.transferObjects.user.LoginType;
import shared.transferObjects.user.LoginUser;

public class LoginModelServerImp implements LoginModelServer
{
  private LoginModelDatabase loginModelDatabase;

  public LoginModelServerImp()
  {
    this.loginModelDatabase= new LoginModelDatabaseImp();
  }

  @Override public LoginType login(LoginUser user)
  {
    return loginModelDatabase.login(user);
  }
}
