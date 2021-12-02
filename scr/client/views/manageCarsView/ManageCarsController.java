package client.views.manageCarsView;

import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ManageCarsController implements ViewController {

    @FXML private ComboBox statusComboBox;
    @FXML private ImageView bigImageView;
    @FXML private ImageView oneImageView;
    @FXML private ImageView twoImageView;
    @FXML private ImageView threeImageView;

    @Override
    public void init() {
        statusComboBox.getItems().addAll("Available","Service", "Cleaning", "Unavailable");
    }

    public void onCancel(MouseEvent mouseEvent) {
    }

    public void onSave(MouseEvent mouseEvent) {
    }

    public void oneImageView(MouseEvent mouseEvent) {
        swipeImages(oneImageView);
    }

    public void twoImageView(MouseEvent mouseEvent) {
        swipeImages(twoImageView);
    }

    public void threeImageView(MouseEvent mouseEvent) {
        swipeImages(threeImageView);
    }

    private void swipeImages(ImageView image) {
        Image tempImageView = bigImageView.getImage();
        bigImageView.setImage(image.getImage());
        image.setImage(tempImageView);

    }
}
