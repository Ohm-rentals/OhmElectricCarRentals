package client.core;

import client.views.ViewController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ViewHandler {
    private ViewModelFactory viewModelFactory;
    private Stage stage, popUpStage;
    private Parent root;

    Scene scene;
    ViewController viewController;
    String actualPath;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewModelFactory = viewModelFactory;
        stage = new Stage();
        popUpStage = new Stage();
    }

    public void openCatalogView(){
        actualPath ="../views/catalogView/catalogView.fxml";
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }

    public void openCreateAccountView(){
        Scene newScene = new Scene(getRoot("../views/createAccountView/createAccountView.fxml"));
        openNewWindow(newScene);
    }


    public void openLoginView(){
        Scene newScene = new Scene(getRoot("../views/loginView/loginView.fxml"));
        openNewWindow(newScene);
    }

    public void openMyAccountView(){
        actualPath ="../views/myAccountView/myAccountView.fxml";
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }

    public void openManageAccountView(){
        actualPath ="../views/manageAccountView/manageAccountsView.fxml";
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }

    public void openManageReservationsView(){
        actualPath ="../views/manageReservationsView/manageReservationsView.fxml";
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }


    public void openManageCarsView(){
        actualPath = "../views/manageCarsView/manageCarsView.fxml";
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }

    public void openSearchView(){
        actualPath = "../views/searchView/searchView.fxml";
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }


    private Parent getRoot(String path) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));
            root = loader.load();
            viewController = loader.getController();
            viewController.init(this, viewModelFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return root;
    }

    private double xOffset = 0; //Moving the stage without title bar...
    private double yOffset = 0; //Moving the stage without title bar...

    private void openNewWindow(Scene scene) {
       // if (popUpStage != null)
         //   popUpStage.close();
        popUpStage = new Stage();
        popUpStage.setScene(scene);
        popUpStage.initModality(Modality.APPLICATION_MODAL);
        popUpStage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                popUpStage.setX(event.getScreenX() - xOffset);
                popUpStage.setY(event.getScreenY() - yOffset);
            }
        });


        popUpStage.show();
    }

    public void refreshActualView() {
        scene = new Scene(getRoot(actualPath));
        stage.setScene(scene);
        stage.show();
    }
}
