package client.model;


import client.networking.User.UsersClient;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

public class UsersModelManager implements UsersModel {

    private UsersClient usersClient;

    public UsersModelManager(UsersClient usersClient) {
        this.usersClient = usersClient;
    }

    @Override
    public void login(Email email, Password password) {
        usersClient.login(email, password);
    }

    @Override
    public void createUser(User user) {
        usersClient.createUser(user);
    }

    @Override
    public void editUser(String id, User user) {
        usersClient.editUser(id, user);
    }

    @Override
    public void deleteUser(String id) {
        usersClient.deleteUser(id);
    }
}
