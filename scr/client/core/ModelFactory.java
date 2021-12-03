package client.core;

import client.model.UsersModelManager;
import client.model.UsersModel;

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
