package client.views.loginView;

import client.model.UsersModel;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;

public class LoginViewModel {

    private UsersModel usersModel;

    public LoginViewModel(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public void login(String email, String password) {
        usersModel.login(new Email(email), new Password(password));
    }
}
