package client.networking.User;

import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;
import shared.util.Subject;

public interface UsersClient extends Subject {
    void login(Email email, Password password);
    void connectUser();
    void createUser(User user);
    void editUser(String id, User user);
    void deleteUser(String id);

}
