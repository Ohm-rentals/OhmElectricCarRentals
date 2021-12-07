package client.views.utils.images;


import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class CarImage implements Serializable {
    private String fileName, extension;
    private byte[] rawImage;

    public CarImage() {
        this.fileName = "";
        this.extension = "jpeg";
        try {
            this.rawImage = giveMeRawImage( ImageIO.read(getClass().getResource("car_model_default.png")));
        } catch (IOException e) {
            this.rawImage = null;
        }
    }

    public CarImage(BufferedImage bufferedImage, String file) {
        this.fileName = file.substring(0,file.lastIndexOf('.'));
        this.extension = file.substring(file.lastIndexOf('.') + 1, (file.length()));
        this.rawImage = giveMeRawImage(bufferedImage);
    }

    private byte[] giveMeRawImage(BufferedImage bufferedImage) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            javax.imageio.ImageIO.write(bufferedImage, extension, baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray();
    }

    public Image getImage() {
        BufferedImage bufferedAvatar = null;
        try {
            bufferedAvatar = javax.imageio.ImageIO.read(new ByteArrayInputStream(rawImage));
            Image image = SwingFXUtils.toFXImage(bufferedAvatar, null);
            return image;
        } catch (IOException e) {
        }
        return new Image(getClass().getResourceAsStream("car_model_default.png"));
    }

}
