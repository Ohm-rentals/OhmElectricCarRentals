package client.views.createAccountView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shared.transferObjects.user.Customer;
import shared.transferObjects.user.Email;
import shared.transferObjects.user.Password;
import shared.transferObjects.user.User;

public class CreateAccountController implements ViewController
{
  @FXML private TextField fNameField;
  @FXML private TextField lNameField;
  @FXML private TextField dobDayField;
  @FXML private TextField dobMonthField;
  @FXML private TextField dobYearField;
  @FXML private TextField licenseNoField;
  @FXML private TextField phoneField;
  @FXML private TextField countryField;
  @FXML private TextField cityField;
  @FXML private TextField zipField;
  @FXML private TextField emailField;
  @FXML private TextField streetField;
  @FXML private TextField passwordOneField;
  @FXML private TextField passwordTwoField;

  private ViewHandler viewHandler;
  private Stage stage;


  @Override public void init()
  {
    //reset();
   // this.viewHandler=viewHandler;
  //  this.stage=stage;

  }
/*
  @Override public void reset()
  {
    clearFields();
  }


 */
  public void createAccountButton(ActionEvent actionEvent)
  {
    if (!isFieldsEmpty() && passwordCheck())
    {
      Email email = new Email(emailField.getText());
      Password password = new Password(passwordOneField.getText());
      User user = new Customer(fNameField.getText(),lNameField.getText(),countryField.getText(),cityField.getText(),streetField.getText(),Integer.parseInt(zipField.getText()),Integer.parseInt(phoneField.getText()),password,email,Integer.parseInt(licenseNoField.getText()));
    }

  }

  public void cancelButton(ActionEvent actionEvent)
  {
    stage.close();
  }

  private boolean isFieldsEmpty()
  {
    return fNameField.getText().isEmpty() && lNameField.getText().isEmpty()
        && dobDayField.getText().isEmpty() && dobMonthField.getText().isEmpty()
        && dobYearField.getText().isEmpty() && licenseNoField.getText()
        .isEmpty() && phoneField.getText().isEmpty() && countryField.getText()
        .isEmpty() && cityField.getText().isEmpty() && zipField.getText()
        .isEmpty() && emailField.getText().isEmpty() && streetField.getText()
        .isEmpty();
  }

  private void clearFields()
  {
    fNameField.clear();
    lNameField.clear();
    dobDayField.clear();
    dobMonthField.clear();
    dobYearField.clear();
    licenseNoField.clear();
    phoneField.clear();
    countryField.clear();
    cityField.clear();
    zipField.clear();
    emailField.clear();
    streetField.clear();
    passwordOneField.clear();
    passwordTwoField.clear();
  }

  private boolean passwordCheck()
  {
    return passwordOneField.equals(passwordTwoField);
  }
}
