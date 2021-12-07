package client.views.extraObjectsView.menuBar;

import client.core.viewHandler.View;
import client.core.viewHandler.ViewHandler;
import client.model.personal.Personal;
import client.model.personal.status.Stat;
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
            viewHandler.openNewView(View.LOGIN);
        }

        if (personal.getStatus().equals(Stat.ONLINE)){
            personal.logOut();
          //  viewHandler.refreshActualView(); // what shoul I do when I log out? which view should I GO
            viewHandler.openView(View.SEARCH);
        }


    }

    public void onMyAccount(MouseEvent mouseEvent) {
        viewHandler.openView(View.MY_ACCOUNT);
    }

    public void onManageAccount(MouseEvent mouseEvent) {
        viewHandler.openView(View.MANAGE_ACCOUNT);
    }

    public void onManageReservations(MouseEvent mouseEvent) {
        viewHandler.openView(View.MANAGE_RESERVATIONS);

    }

    public void onManageCars(MouseEvent mouseEvent) {
        viewHandler.openView(View.MANAGE_CARS);
    }
}
