package client.model.users;


import client.model.personal.Personal;
import client.networking.user.UsersClient;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class UsersModelManager implements UsersModel {

    private PropertyChangeSupport support;
    private User identity;

    private UsersClient usersClient;

    public UsersModelManager(UsersClient usersClient) {
        support = new PropertyChangeSupport(this);
        this.usersClient = usersClient;
    }

    @Override
    public void login(Email email, Password password) {
        identity = usersClient.login(email, password);
        if (identity == null) {
            support.firePropertyChange("LOGIN_ERROR", null, null);
        } else {
            Personal personal = Personal.getPersonal();
            personal.setIdentity(identity);
            support.firePropertyChange("LOGIN_SUCCESS", null, identity);
        }
    }



    @Override
    public void createUser(User user) {
        System.out.println("ok desde model");
        usersClient.createUser(user);
    }

    @Override
    public void editUser(int userID, User user) {
        System.out.println("desde model");
        usersClient.editUser(userID, user);

    }

    @Override
    public void deleteUser(int userID) {
        System.out.println("from model");
        usersClient.deleteUser(userID);
    }

    @Override
    public boolean existUser(Email email) {
        return usersClient.existUser(email);
    }

    @Override
    public List<User> getUsersList() {
        return usersClient.getUsersList();
    }

    @Override
    public void addListener(String evt, PropertyChangeListener listener) {
        support.addPropertyChangeListener(evt, listener);
    }

    @Override
    public void removeListener(String evt, PropertyChangeListener listener) {
        support.removePropertyChangeListener(evt, listener);

    }
}
