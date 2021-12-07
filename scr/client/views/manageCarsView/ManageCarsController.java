package client.views.manageCarsView;

import client.core.viewHandler.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.extraObjectsView.LoadPanel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ManageCarsController implements ViewController {

    @FXML private ComboBox statusComboBox;
    @FXML private ImageView bigImageView;
    @FXML private ImageView oneImageView;
    @FXML private ImageView twoImageView;
    @FXML private ImageView threeImageView;


    @FXML private HBox menuBarHBox;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        menuBarHBox.getChildren().add(new LoadPanel().load("../extraObjectsView/menuBar/menuBar.fxml", viewHandler));
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

    public void onUpdate(MouseEvent mouseEvent) {
    }
}
