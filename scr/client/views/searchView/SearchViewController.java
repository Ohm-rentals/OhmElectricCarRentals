package client.views.searchView;

import client.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SearchViewController implements ViewController {

    @FXML private ComboBox<String> locationComboBox;
    @FXML private ComboBox<String> rangeComboBox;
    @FXML private DatePicker fromDatePicker;
    @FXML private DatePicker toDatePicker;
    private Label selectedLocation = new Label();


    private SearchViewModel searchViewModel = new SearchViewModel(); // to create in the factory

    @Override
    public void init() {
        rangeComboBox.getItems().setAll("0...1,000 DKK", "1,000...3,000 DKK", "3,000...5,000 DKK", "> 5,000 DKK");
        locationComboBox.getItems().setAll("Horsens", "Aarhus", "Kobenhavn", "Odense");

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
