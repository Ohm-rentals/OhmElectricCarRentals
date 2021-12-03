package client.core;

import client.model.users.UsersModelManager;
import client.model.users.UsersModel;

public class ModelFactory {
    private ClientFactory clientFactory;
    private UsersModel usersModel;

    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public UsersModel getUsersModel() {
        if (this.usersModel == null) {
            return new UsersModelManager(clientFactory.getUserClient());
        }
        return usersModel;
    }
}
