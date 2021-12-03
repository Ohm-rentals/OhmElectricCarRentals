package server.model.login;

import shared.transferObjects.user.LoginType;
import shared.transferObjects.user.LoginUser;

public interface LoginModelServer
{
  LoginType login(LoginUser user);
}
