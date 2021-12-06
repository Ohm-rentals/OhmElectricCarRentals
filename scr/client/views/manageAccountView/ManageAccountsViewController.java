package client.views.manageAccountView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.personal.Personal;
import client.views.ViewController;
import client.views.extraObjectsView.LoadPanel;
import client.views.myAccountView.MyAccountViewModel;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import shared.transferObjects.user.UserKind;

public class ManageAccountsViewController implements ViewController {
    @FXML private HBox menuBarHBox;
    private MyAccountViewModel myAccountViewModel;
    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        myAccountViewModel = viewModelFactory.getMyAccountViewModel();
        menuBarHBox.getChildren().add(new LoadPanel().load("../extraObjectsView/menuBar/menuBar.fxml", viewHandler));
        
    }

    public void onUpdate(MouseEvent mouseEvent) {
    }

    public void onCancel(MouseEvent mouseEvent) {
    }
}
