package client.model;


import client.networking.User.UsersClient;
import com.sun.javafx.geom.transform.Identity;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UsersModelManager implements UsersModel {

    private PropertyChangeSupport support;
    private User identity;

    private UsersClient usersClient;

    public UsersModelManager(UsersClient usersClient) {
        support = new PropertyChangeSupport(this);
        this.usersClient = usersClient;
        usersClient.connectUser();
    }

    @Override
    public void login(Email email, Password password) {
        identity = usersClient.login(email, password);
        if (identity == null) {
            support.firePropertyChange("LOGIN_ERROR", null, null);
        } else {
            support.firePropertyChange("LOGIN_SUCCESS", null, identity);
        }

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

    @Override
    public void addListener(String evt, PropertyChangeListener listener) {
        support.addPropertyChangeListener(evt, listener);
    }

    @Override
    public void removeListener(String evt, PropertyChangeListener listener) {
        support.removePropertyChangeListener(evt, listener);

    }
}
