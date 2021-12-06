package client.views.createAccountView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.utils.other.Error;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class CreateAccountViewController implements ViewController {

    @FXML private TextField firstNameTextField = new TextField("");
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

    CreateAccountViewModel createAccountViewModel;



    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        errorText.setText("");
        createAccountViewModel = viewModelFactory.getCreateAccountViewModel(); //Change this
        firstNameTextField.textProperty().bindBidirectional(createAccountViewModel.firstNameProperty());
        createAccountViewModel.DOBProperty().bind(DOBDatePicker.styleProperty());
      /*
        lastNameTextField.textProperty().bindBidirectional(createAccountViewModel.());
        firstNameTextField.textProperty().bindBidirectional(createAccountViewModel.firstNameProperty());
        firstNameTextField.textProperty().bindBidirectional(createAccountViewModel.firstNameProperty());
        firstNameTextField.textProperty().bindBidirectional(createAccountViewModel.firstNameProperty());
        firstNameTextField.textProperty().bindBidirectional(createAccountViewModel.firstNameProperty());
        firstNameTextField.textProperty().bindBidirectional(createAccountViewModel.firstNameProperty());
        //createAccountViewModel.firstNameProperty().bind(firstNameTextField.textProperty());


       */

       // createAccountHBox.setDisable(true);
        kindHBox.setVisible(false);

    }

    public void onClose(MouseEvent mouseEvent) {
        Window window = firstNameTextField.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSE_REQUEST));

    }


    public void createAccount(MouseEvent mouseEvent) { //change to through errors
        if (fieldsEmpty()) {
            errorText.setText(Error.EMPTY_FIELDS.getMessage());
        } else if (!equalPasswords()) {
            errorText.setText(Error.PASSWORD_NOT_MACH.getMessage());
        } else if (isMinor()) {
            errorText.setText(Error.USER_AGE_INVALID.getMessage());
        } else {
            createAccountViewModel.createAccount();
            errorText.setText("");
        }

    }

    private boolean equalPasswords() { //change to through errors
        return passwordPasswordField.getText().equals(rePasswordPasswordField.getText());
    }

    private boolean fieldsEmpty() { //change to through errors
        return firstNameTextField.getText().isEmpty() ||
                lastNameTextField.getText().isEmpty() ||
                emailTextField.getText().isEmpty() ||
                phoneTextField.getText().isEmpty() ||
                licenseTextField.getText().isEmpty() ||
                zipTextField.getText().isEmpty() ||
                (DOBDatePicker.getValue() == null) ||
                streetTextField.getText().isEmpty() ||
                numberTextField.getText().isEmpty() ||
                cityTextField.getText().isEmpty() ||
                countryTextField.getText().isEmpty();
    }

    private boolean isMinor() {
        return (!DOBDatePicker.getValue().isBefore(LocalDate.now().minusYears(18)));
    }

}
