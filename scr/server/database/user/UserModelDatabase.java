package server.database.user;

import shared.transferObjects.user.LoginType;
import shared.transferObjects.user.User;

import java.util.ArrayList;

public interface UserModelDatabase
{
  ArrayList<User> getUsersByType(LoginType loginType);
  User getUserById(int id, LoginType loginType);
  void createUser(User user);
  void updateUser(User user);
  void deleteUser(User user);
}
