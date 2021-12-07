package client.views.createCarView;

import client.core.ViewModelFactory;
import client.core.viewHandler.ViewHandler;
import client.views.ViewController;
import client.views.utils.images.CarImage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CreateCarViewController implements ViewController {

    @FXML private Button addMainPhoto, addOnePhoto, addTowPhoto, addThreePhoto;
    private ViewHandler viewHandler;
    private CreateCarViewModel createCarViewModel;

    @FXML private ImageView oneImageView, twoImageView, threeImageView, mainImageView;
    @FXML private Spinner<String> yearSpinner;
    private CarImage carImage;
    private BufferedImage bufferedImage = null;




    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.createCarViewModel = viewModelFactory.getCreateCarViewModel();
        addMainPhoto.setOnAction(actionEvent -> addPhoto(mainImageView));
        addOnePhoto.setOnAction(actionEvent -> addPhoto(oneImageView));
        addTowPhoto.setOnAction(actionEvent -> addPhoto(twoImageView));
        addThreePhoto.setOnAction(actionEvent -> addPhoto(threeImageView));
    }

    public void onClose(MouseEvent mouseEvent) {
        Window window = addMainPhoto.getScene().getWindow();
        window.fireEvent(new WindowEvent(window,WindowEvent.WINDOW_CLOSE_REQUEST));
    }

    public void onCreateCar(MouseEvent mouseEvent) {

    }

    public void addPhoto(ImageView imageView) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif", "*.bmp", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            try {
                bufferedImage = ImageIO.read(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            carImage = new CarImage(bufferedImage, file.getName());
            imageView.setImage(carImage.getImage());
        }
    }

}
