package client.model;

import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;
import shared.util.Subject;

public interface UsersModel extends Subject {
    void login(Email email, Password password);
    void createUser(User user);
    void editUser(String id, User user);
    void deleteUser(String id);
}
