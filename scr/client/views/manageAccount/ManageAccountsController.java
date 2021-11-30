package client.views.manageAccount;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import shared.transferObjects.User;

public class ManageAccountsController implements ViewController
{
  @FXML private TableView<User> accountTable;
  @FXML private Button searchButton;
  @FXML private TextField searchField;
  @FXML private ChoiceBox<String> idChoice;
  @FXML private TextField fNameField;
  @FXML private TextField lNameField;
  @FXML private TextField dobField;
  @FXML private Label idLabel;
  @FXML private TextField idField;
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
    idChoice.getItems().add("Customer Id");
    idChoice.getItems().add("Employee Id");


  }

  public void searchButton(ActionEvent actionEvent)
  {
  }

  public void radioAdmin(ActionEvent actionEvent)
  {

  }

  public void radioFrontDesk(ActionEvent actionEvent)
  {
  }

  public void radioCustomer(ActionEvent actionEvent)
  {
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
}
