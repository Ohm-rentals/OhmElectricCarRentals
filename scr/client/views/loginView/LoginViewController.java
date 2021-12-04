package client.views.loginView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.personal.Personal;
import client.model.personal.status.Stat;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.beans.PropertyChangeEvent;

public class LoginViewController implements ViewController {

    @FXML private TextField textFieldEmail;
    @FXML private PasswordField passwordFieldPassword;
    @FXML private Text errorText;


    private ViewHandler viewHandler;
    private LoginViewModel loginViewModel;


    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

        this.viewHandler = viewHandler;
        this.loginViewModel = viewModelFactory.getLoginViewModel();
     //   ((Stage) textFieldEmail.getScene().getWindow()).initStyle(StageStyle.UNDECORATED);
        loginViewModel.addListener("LOGIN_ERROR", this::onErrorLogin);
        loginViewModel.addListener("LOGIN_SUCCESS", this::onSuccessLogin);

    }



    private void onSuccessLogin(PropertyChangeEvent event) {
        viewHandler.openSearchView();
        closeWindow();
    }

    private void onErrorLogin(PropertyChangeEvent event) {
        errorText.setText(event.getPropertyName());
    }

    public void onClose(MouseEvent mouseEvent) {
        closeWindow();
    }

    public void onCreateAccount(MouseEvent mouseEvent) {
        viewHandler.openCreateAccountView();

    }

    public void login(MouseEvent mouseEvent) {
        loginViewModel.login(textFieldEmail.getText(), passwordFieldPassword.getText());
    }

    public void requestPassword(MouseEvent mouseEvent) {

    }

    private void closeWindow() {
        Window window = textFieldEmail.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSE_REQUEST));
    }
}
