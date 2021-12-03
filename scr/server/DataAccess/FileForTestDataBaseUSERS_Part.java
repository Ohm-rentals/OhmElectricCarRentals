package server.DataAccess;


//// PLEASE DELETE THIS FILE WHEN YOU HAVE THE DATA BASE TO TEST

import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

import java.util.ArrayList;
import java.util.List;

public class FileForTestDataBaseUSERS_Part implements UsersData{


    @Override
    public User login(Email email, Password password) {
        System.out.println(email + "/ " + password + " -------- Validation here WORKING");
        return null;
    }
    @Override
    public void storeUser(User user) {
        System.out.println(user + ": Users Store Perfect (You wish..)");
    }

    @Override
    public void updateUser(String mail, User newUser) {
        System.out.println(mail + newUser + ": Users Updated Perfect (You wish..)");

    }

    @Override
    public void deleteUser(User identity) {
        System.out.println("I deleted this madafaka.." + identity);
    }

    @Override
    public List<User> getUserList() {
        System.out.println("This is the list");
        return null;
    }

    @Override
    public boolean existUser(String mail) {
        return false;
    }
}
