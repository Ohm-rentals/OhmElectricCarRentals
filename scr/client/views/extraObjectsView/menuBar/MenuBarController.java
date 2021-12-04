package client.views.extraObjectsView.menuBar;

import client.core.ViewHandler;
import client.model.personal.Personal;
import client.model.personal.status.Stat;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import shared.transferObjects.user.UserKind;

public class MenuBarController  {
    @FXML private HBox welcomeHBox;
    @FXML private Text nameText;
    @FXML private Text logText;
    @FXML private Text text1;
    @FXML private Text text2;
    @FXML private Text text3;
    @FXML private Text text4;

    private ViewHandler viewHandler;
    private Personal personal;

    public MenuBarController() {
    }

    public void init(ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        welcomeHBox.setVisible(false);
        logText.setText("|LogIn|");
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        personal = Personal.getPersonal();
        if (personal.getStatus().equals(Stat.ONLINE)) {
            nameText.setText(personal.getIdentity().getfName());
            welcomeHBox.setVisible(true);
            logText.setText("|Logout|");
            text1.setText("|My Account|");
            text2.setText(personal.getKind().equals(UserKind.CUSTOMER) ? "" : "|Manage Accounts|");
            text3.setText(personal.getKind().equals(UserKind.CUSTOMER) ? "" : "|Manage Reservations|");
            text4.setText(personal.getKind().equals(UserKind.CUSTOMER) ? "" : "|Manage Cars|");
        }

    }

    public void logInAction(MouseEvent mouseEvent) {
        if (personal.getStatus().equals(Stat.OFFLINE)) {
            viewHandler.openLoginView();
        } else {
            personal.logOut();
            viewHandler.openSearchView();
        }


    }

    public void onMyAccount(MouseEvent mouseEvent) {
        viewHandler.openManageAccount();
    }
}
