package shared.networking;

import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIUserServer extends Remote {
    void login(Email email, Password password) throws RemoteException;
    void connectUser() throws RemoteException;
    void createUser(User user) throws RemoteException;
    void editUser(User user) throws RemoteException;
    void deleteUser(User user) throws RemoteException;

}
