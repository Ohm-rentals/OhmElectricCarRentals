package client.views.extraObjectsView;

import client.core.ViewHandler;
import client.views.extraObjectsView.menuBar.MenuBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class LoadPanel {

    public Pane load(String path, ViewHandler viewHandler) {
        FXMLLoader loader = new FXMLLoader();
        Pane newLoadedPane = null;
        loader.setLocation(getClass().getResource(path));
        try {
             newLoadedPane = loader.load();
            MenuBarController viewController = loader.getController();
            viewController.init(viewHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newLoadedPane;
    }

}
