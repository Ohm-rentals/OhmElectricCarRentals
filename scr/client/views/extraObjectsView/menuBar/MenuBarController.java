package client.views.extraObjectsView.menuBar;

import client.model.personal.Personal;
import client.model.personal.status.Stat;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import shared.transferObjects.user.UserKind;

public class MenuBarController {
    @FXML private Text text1;
    @FXML private Text text2;
    @FXML private Text text3;
    @FXML private Text text4;

    public MenuBarController() {
    }


    public void init() {
        Personal personal = Personal.getPersonal();
        text1.setText(personal.getStatus().equals(Stat.ONLINE) ? "|My Account|" : "|LogIn|");
        text2.setText(personal.getKind().equals(UserKind.CUSTOMER) ? "" : "|Manage Accounts|");
        text3.setText(personal.getKind().equals(UserKind.CUSTOMER) ? "" : "|Manage Reservations|");
        text4.setText(personal.getKind().equals(UserKind.CUSTOMER) ? "" : "|Manage Cars|");
    }

    public void logInAction(MouseEvent mouseEvent) {
    }
}
