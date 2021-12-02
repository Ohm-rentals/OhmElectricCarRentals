package server.database.login;

import shared.transferObjects.user.LoginUser;
import shared.transferObjects.user.UserType;

public interface LoginModelDatabase
{
  UserType login(LoginUser user);
}
