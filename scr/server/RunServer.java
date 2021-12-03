package server;

import server.model.user.UsersManagerImp;
import server.networking.RMIUserServerImp;

import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException {
        RMIUserServerImp rmiUserServerImp = new RMIUserServerImp(new UsersManagerImp());
        rmiUserServerImp.startServer();
    }
}