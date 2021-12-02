package client.views.loginView;

import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class LoginViewController implements ViewController {
    @FXML TextField textFieldEmail;
    @FXML TextField textFieldPassword;



    @Override
    public void init() {
     //   ((Stage) textFieldEmail.getScene().getWindow()).initStyle(StageStyle.UNDECORATED);

    }

    public void onClose(MouseEvent mouseEvent) {
        Window window = textFieldEmail.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void onCreateAccount(MouseEvent mouseEvent) {

    }

    public void login(MouseEvent mouseEvent) {
    }

    public void requestPassword(MouseEvent mouseEvent) {
    }
}
