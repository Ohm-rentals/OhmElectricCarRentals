package server.DataAccess;

import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

import java.util.List;

public interface UsersData {
  User login(Email email, Password password);
  void storeUser(User user);
  void updateUser(String mail, User newUser);
  void deleteUser(User identity);
  List<User> getUserList();
  boolean existUser(String mail);
}
