package client.views.manageAccount;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import shared.transferObjects.user.User;

public class ManageAccountsController implements ViewController
{

  @FXML private TableView<User> accountTable;
  @FXML private TextField searchField;
  @FXML private ChoiceBox<String> idChoice;
  @FXML private TextField fNameField;
  @FXML private TextField lNameField;
  @FXML private TextField dobDayField;
  @FXML private TextField dobMonthField;
  @FXML private TextField dobYearField;
  @FXML private Label idLabel;
  @FXML private Label gottenIdLabel;
  @FXML private Label ssnLicenseNoLabel;
  @FXML private TextField ssnLicenseNoField;
  @FXML private TextField phoneField;
  @FXML private TextField countryField;
  @FXML private TextField cityField;
  @FXML private TextField zipField;
  @FXML private TextField emailField;
  @FXML private TextField streetField;
  

  @Override public void init(ViewHandler viewHandler,
      ViewModelFactory viewModelFactory, Stage stage)
  {



  }

  @Override public void reset()
  {
    clearFields();
    setIdChoiceBox();
    setCustomer();
    gottenIdLabel.setText("");
  }

  public void searchButton(ActionEvent actionEvent)
  {
  }

  public void radioAdmin(ActionEvent actionEvent)
  {
    setEmployee();
  }

  public void radioFrontDesk(ActionEvent actionEvent)
  {
    setEmployee();
  }

  public void radioCustomer(ActionEvent actionEvent)
  {
    setCustomer();
  }

  public void saveButton(ActionEvent actionEvent)
  {
  }

  public void cancelButton(ActionEvent actionEvent)
  {
  }

  public void backButton(ActionEvent actionEvent)
  {
  }

  private void clearFields()
  {
    fNameField.clear();
    lNameField.clear();
    dobDayField.clear();
    dobMonthField.clear();
    dobYearField.clear();
    ssnLicenseNoField.clear();
    phoneField.clear();
    countryField.clear();
    cityField.clear();
    zipField.clear();
    emailField.clear();
    streetField.clear();
    searchField.clear();
  }

  private void setEmployee()
  {
    idLabel.setText("Employee ID:");
    ssnLicenseNoLabel.setText("SSN:");
  }

  private void setCustomer()
  {
    idLabel.setText("Customer ID:");
    ssnLicenseNoLabel.setText("License No:");
  }

  private void setIdChoiceBox()
  {
    idChoice.getItems().clear();
    idChoice.getItems().add("Customer Id");
    idChoice.getItems().add("Employee Id");
    idChoice.getSelectionModel().select(0);
  }
}
