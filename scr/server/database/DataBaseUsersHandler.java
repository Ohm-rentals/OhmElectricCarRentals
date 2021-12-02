package server.database;

import shared.transferObjects.user.User;

import java.util.List;

public class DataBaseUsersHandler implements UsersData
{

  @Override public void storeUser(User user)
  {
  }

  @Override public void updateUser(String mail, User newUser)
  {

  }

  @Override public User validateUser(String mail, String password)
  {
    return null;
  }

  @Override public List<User> getUserList()
  {
    return null;
  }

  @Override public boolean existUser(String mail)
  {
    return false;
  }

  @Override public void deleteUser(User identity)
  {

  }
}
