package client.views.createAccountView;

import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.stage.WindowEvent;



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
    public void init() {
        createAccountViewModel = new CreateAccountViewModel(); //Change this
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
        errorText.setText("This is a test of the possible errors");
    }

    public void onClose(MouseEvent mouseEvent) {
        Window window = firstNameTextField.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSE_REQUEST));

    }


    public void createAccount(MouseEvent mouseEvent) { //change to through errors
      //  if (fieldsEmpty()) {
            if (equalPasswords()) {
                createAccountViewModel.createAccount();
            } else {
                errorText.setText("Passwords should match!!!");
            }
     //   } else {
      //      errorText.setText("All fields must be completed");
       //     }
    }

    private boolean equalPasswords() { //change to through errors
        return passwordPasswordField.getText().equals(rePasswordPasswordField.getText());
    }

    private boolean fieldsEmpty() { //change to through errors
        return firstNameTextField.getText().isEmpty() &&
                lastNameTextField.getText().isEmpty() &&
                emailTextField.getText().isEmpty() &&
                phoneTextField.getText().isEmpty() &&
                licenseTextField.getText().isEmpty() &&
                streetTextField.getText().isEmpty() &&
                numberTextField.getText().isEmpty() &&
                cityTextField.getText().isEmpty() &&
                countryTextField.getText().isEmpty();
    }

}
