package client.views.myAccountView;


import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.personal.Personal;
import client.views.ViewController;
import client.views.extraObjectsView.LoadPanel;
import client.views.utils.other.AlertControl;
import client.views.utils.other.Message;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import shared.transferObjects.user.UserKind;

public class MyAccountViewController implements ViewController {

    MyAccountViewModel myAccountViewModel;

    @FXML private HBox menuBarHBox;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField emailTextField;
    @FXML private TextField phoneTextField;
    @FXML private TextField licenseTextField;
    @FXML private DatePicker DOBDatePicker;
    @FXML private TextField streetTextField;
    @FXML private TextField numberTextField;
    @FXML private TextField cityTextField;
    @FXML private TextField countryTextField;
    @FXML private TextField zipTextField;
    @FXML private PasswordField passwordPasswordField;
    @FXML private PasswordField rePasswordPasswordField;
    @FXML private Text errorText;
    @FXML private HBox kindHBox;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        kindHBox.setVisible(Personal.getPersonal().getKind().equals(UserKind.ADMIN) ? true : false);
        myAccountViewModel = viewModelFactory.getMyAccountViewModel();
        menuBarHBox.getChildren().add(new LoadPanel().load("../extraObjectsView/menuBar/menuBar.fxml", viewHandler));
        firstNameTextField.setDisable(true);
        lastNameTextField.setDisable(true);
        emailTextField.setDisable(true);

        firstNameTextField.textProperty().bindBidirectional(myAccountViewModel.firstNameProperty());
        lastNameTextField.textProperty().bindBidirectional(myAccountViewModel.lastNameProperty());
        emailTextField.textProperty().bindBidirectional(myAccountViewModel.emailProperty());
        phoneTextField.textProperty().bindBidirectional(myAccountViewModel.phoneProperty());
        /*
        license
        street
        number
        city
        country
        zip
        DOB

         */

    }

    public void onCancel(MouseEvent mouseEvent) {
        AlertControl.confirmationBox(Message.CANCEL);

    }

    public void onUpdate(MouseEvent mouseEvent) {
    }
}
