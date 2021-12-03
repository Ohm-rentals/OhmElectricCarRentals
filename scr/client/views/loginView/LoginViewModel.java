package client.views.loginView;

import client.model.UsersModel;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel implements Subject {

    private UsersModel usersModel;
    private PropertyChangeSupport support;

    public LoginViewModel(UsersModel usersModel) {
        support = new PropertyChangeSupport(this);
        this.usersModel = usersModel;
        usersModel.addListener("LOGIN_ERROR", this::actionLogin);
        usersModel.addListener("LOGIN_SUCCESS", this::actionLogin);
    }

    private void actionLogin(PropertyChangeEvent event) {
        support.firePropertyChange(event);
    }

    public void login(String email, String password) {
        usersModel.login(new Email(email), new Password(password));
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
