package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage stage;
    private Parent root;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        this.stage = new Stage();

    }

    public void openCatalogView(){
        Scene scene = new Scene(getRoot("../views/catalogView/catalogView.fxml"));
        stage.setScene(scene);
        stage.show();
    }

    public void openCreateAccountView(){
        Scene scene = new Scene(getRoot("../views/createAccountView/createAccountView.fxml"));
        stage.setScene(scene);
        stage.show();
    }

    public void openLoginView(){
        Scene scene = new Scene(getRoot("../views/loginView/loginView.fxml"));
        stage.setScene(scene);
        stage.show();
    }

    public void openManageAccount(){
        Scene scene = new Scene(getRoot("../views/catalogView/catalogView.fxml"));
        stage.setScene(scene);
        stage.show();
    }

    public void openManageCars(){
        Scene scene = new Scene(getRoot("../views/manageCarsView/manageCarsView.fxml"));
        stage.setScene(scene);
        stage.show();
    }

    public void openSearchView(){
        Scene scene = new Scene(getRoot("../views/searchView/searchView.fxml"));
        stage.setScene(scene);
        stage.show();
    }


    private Parent getRoot(String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));
            root = loader.load();
            ViewController viewController = loader.getController();
            viewController.init(this, viewModelFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }
}
