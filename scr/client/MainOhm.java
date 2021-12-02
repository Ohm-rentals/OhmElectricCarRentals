package client;

import client.views.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainOhm extends Application {


    @Override
    //TESTING JUST THE VIEWS!! PLEASE DO NOT MODIFY!!! //
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        //loader.setLocation(getClass().getResource("/client/views/catalogView/catalogView.fxml"));
       // loader.setLocation(getClass().getResource("/client/views/searchView/searchView.fxml"));

       loader.setLocation(getClass().getResource("/client/views/loginView/loginView.fxml"));

       // loader.setLocation(getClass().getResource("/client/views/createAccountView/createAccountView.fxml"));
        Parent root = null;
        root = loader.load();
        Scene scene = new Scene(root);
        ViewController viewController = loader.getController();
        viewController.init();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //////////////////////////////////////////////////////
}
