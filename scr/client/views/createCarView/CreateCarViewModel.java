package client.views.createCarView;

import client.views.utils.images.CarImage;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class CreateCarViewModel {
    private StringProperty makeTextField, modelTextField, licenseTextField, yearTextField,
                            seatsTextField, rangeTextField, kmTextField, priceTextField;

    public CreateCarViewModel(){
        this.makeTextField = new SimpleStringProperty();
        this.modelTextField = new SimpleStringProperty();
        this.licenseTextField = new SimpleStringProperty();
        this.yearTextField = new SimpleStringProperty();
        this.seatsTextField = new SimpleStringProperty();
        this.rangeTextField = new SimpleStringProperty();
        this.kmTextField = new SimpleStringProperty();
        this.priceTextField = new SimpleStringProperty();

    }


    public void createCar(CarImage[] carImage) {

    }

    public StringProperty getMakeTextField() {
        return makeTextField;
    }
}
