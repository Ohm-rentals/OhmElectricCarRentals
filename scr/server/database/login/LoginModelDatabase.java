package server.database.login;

import shared.transferObjects.user.LoginUser;
import shared.transferObjects.user.LoginType;

public interface LoginModelDatabase
{
  LoginType login(LoginUser user);
}
