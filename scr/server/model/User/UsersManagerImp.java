package server.model.User;

import server.DataAccess.FileForTestDataBaseUSERS_Part;
import server.DataAccess.UsersData;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

public class UsersManagerImp implements UsersManager {

    UsersData usersData = new FileForTestDataBaseUSERS_Part(); //Change this


    @Override
    public void login(Email email, Password password) {
        usersData.login(email, password);
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void editUser(String id, User user) {

    }

    @Override
    public void deleteUser(String id) {

    }
}
