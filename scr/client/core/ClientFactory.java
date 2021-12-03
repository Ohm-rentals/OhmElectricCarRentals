package client.core;


import client.networking.User.RMIUsersClient;
import client.networking.User.UsersClient;

public class ClientFactory {
    private UsersClient userClient;

    public UsersClient getUserClient() {
        if (this.userClient == null) {
            return (new RMIUsersClient());
        }
        return userClient;
    }
}
