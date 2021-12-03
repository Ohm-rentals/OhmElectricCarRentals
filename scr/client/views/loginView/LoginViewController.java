package client.views.loginView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class LoginViewController implements ViewController {
    @FXML TextField textFieldEmail;
    @FXML PasswordField passwordFieldPassword;

    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;



    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.loginViewModel = viewModelFactory.getLoginViewModel();
     //   ((Stage) textFieldEmail.getScene().getWindow()).initStyle(StageStyle.UNDECORATED);

    }

    public void onClose(MouseEvent mouseEvent) {
        Window window = textFieldEmail.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void onCreateAccount(MouseEvent mouseEvent) {
        viewHandler.openCreateAccountView();
    }

    public void login(MouseEvent mouseEvent) {
        loginViewModel.login(textFieldEmail.getText(), passwordFieldPassword.getText());
    }

    public void requestPassword(MouseEvent mouseEvent) {

    }
}
