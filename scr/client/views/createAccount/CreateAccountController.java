package client.views.createAccount;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController implements ViewController
{
  @FXML private TextField fNameField;
  @FXML private TextField lNameField;
  @FXML private TextField dobField;
  @FXML private TextField licenseNoField;
  @FXML private TextField phoneField;
  @FXML private TextField countryField;
  @FXML private TextField cityField;
  @FXML private TextField zipField;
  @FXML private TextField emailField;
  @FXML private TextField streetField;

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory, Stage stage)
  {
    reset();

  }

  @Override public void reset()
  {
    fNameField.clear();
    lNameField.clear();
    dobField.clear();
    licenseNoField.clear();
    phoneField.clear();
    countryField.clear();
    cityField.clear();
    zipField.clear();
    emailField.clear();
    streetField.clear();
  }

  public void createAccountButton(ActionEvent actionEvent)
  {
  }

  public void cancelButton(ActionEvent actionEvent)
  {
  }

  private boolean isFieldsEmpty()
  {
    return fNameField.getText().isEmpty() && lNameField.getText().isEmpty()
        && dobField.getText().isEmpty() && licenseNoField.getText().isEmpty()
        && phoneField.getText().isEmpty() && countryField.getText().isEmpty()
        && cityField.getText().isEmpty() && zipField.getText().isEmpty()
        && emailField.getText().isEmpty() && streetField.getText().isEmpty();
  }
}
