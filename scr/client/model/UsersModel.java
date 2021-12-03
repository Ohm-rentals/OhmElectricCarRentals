package client.model;

import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

public interface UsersModel {
    void login(Email email, Password password);
    void createUser(User user);
    void editUser(String id, User user);
    void deleteUser(String id);
}
