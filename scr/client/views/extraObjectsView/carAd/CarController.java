package client.views.extraObjectsView.carAd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class CarController  {
    @FXML private Button reserveButton;
    @FXML private Text nameText;
    String name;


    public void init(String car) {
        this.name = car;
        nameText.setText(car);
    }

    public void onReserve(ActionEvent actionEvent) {

        System.out.println(name);
    }
}
