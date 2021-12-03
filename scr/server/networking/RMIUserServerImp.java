package server.networking;

import server.DataAccess.FileForTestDataBaseUSERS_Part;
import server.DataAccess.UsersData;
import server.model.User.UsersManager;
import shared.networking.RMIUserServer;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIUserServerImp implements RMIUserServer {


    private UsersManager usersManager;

    public RMIUserServerImp(UsersManager usersManager) throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        this.usersManager = usersManager;
    }

    public void startServer() throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("UserServer", this);
        System.out.println("Server started...");
    }

    @Override
    public void login(Email email, Password password) throws RemoteException {
        System.out.println("Desde server");
        usersManager.login(email, password);
    }

    @Override
    public void connectUser() throws RemoteException {

    }

    @Override
    public void createUser(User user) throws RemoteException {

    }

    @Override
    public void editUser(User user) throws RemoteException {

    }

    @Override
    public void deleteUser(User user) throws RemoteException {

    }


}
