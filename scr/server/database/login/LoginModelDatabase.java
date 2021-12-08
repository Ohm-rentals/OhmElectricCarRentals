package server.database.login;

import shared.transferObjects.user.*;

public interface LoginModelDatabase
{
  User login(Email email, Password password);
}
