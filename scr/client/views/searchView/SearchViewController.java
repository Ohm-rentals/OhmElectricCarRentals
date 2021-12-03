package client.views.searchView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.personal.Personal;
import client.model.personal.status.Stat;
import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class SearchViewController implements ViewController {

    @FXML private ComboBox<String> locationComboBox;
    @FXML private ComboBox<String> rangeComboBox;
    @FXML private DatePicker fromDatePicker;
    @FXML private DatePicker toDatePicker;
    @FXML private Text logInText; //Change This

    private Label selectedLocation = new Label();


    private SearchViewModel searchViewModel = new SearchViewModel(); // to create in the factory

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        setMenuBar();
        rangeComboBox.getItems().setAll("0...1,000 DKK", "1,000...3,000 DKK", "3,000...5,000 DKK", "> 5,000 DKK");
        locationComboBox.getItems().setAll("Horsens", "Aarhus", "Kobenhavn", "Odense");

    }

    private void setMenuBar() {
        Personal personal = Personal.getPersonal();
        System.out.println("the status is:" + personal.getStatus());
        logInText.setText(personal.getStatus().equals(Stat.ONLINE) ? "Settings" : "Login");
    }

    public void logInAction(MouseEvent mouseEvent) {
        searchViewModel.onLogIn();
    }

    public void searchAction(ActionEvent actionEvent) {
        searchViewModel.onSearch(locationComboBox.getSelectionModel().getSelectedItem(),
                                 rangeComboBox.getSelectionModel().getSelectedItem(),
                                 fromDatePicker.getValue(),
                                 toDatePicker.getValue());

    }
}
