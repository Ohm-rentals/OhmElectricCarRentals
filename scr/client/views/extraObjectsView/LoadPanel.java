package client.views.extraObjectsView;

import client.views.extraObjectsView.menuBar.MenuBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoadPanel {

    public Pane load(String path) {
        FXMLLoader loader = new FXMLLoader();
        Pane newLoadedPane = null;
        loader.setLocation(getClass().getResource(path));
        try {
             newLoadedPane = loader.load();
             MenuBarController viewController = loader.getController();
             viewController.init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newLoadedPane;
    }

}
