package client.networking.User;

import shared.networking.ClientCallback;
import shared.networking.RMIUserServer;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class RMIUsersClient implements UsersClient, ClientCallback {

    private RMIUserServer userServer;
    private PropertyChangeSupport support;

    @Override
    public void connectUser() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            userServer = (RMIUserServer) registry.lookup("UserServer");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void login(Email email, Password password) {
        connectUser(); //Change This
        try {
            userServer.login(email, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createUser(User user) {


    }

    @Override
    public void editUser(String Id, User user) {

    }

    @Override
    public void deleteUser(String Id) {

    }



    //Start ClientCallback

    @Override
    public void updateChanges() throws RemoteException {
        support.firePropertyChange("Test", null, null);
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
