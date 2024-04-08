package controller;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class PantallaCarruselController {
	public static int numeroDeFoto = 1;

    @FXML
    private ImageView PantallaCarrusel;

    // Event Listener on Button.onAction
    @FXML
    public void imagenAnterio(ActionEvent event) {
        if (numeroDeFoto >= 3) {
            numeroDeFoto = 1;
        } else {
            numeroDeFoto++;
        }
        actualizarImagen();
    }

    // Event Listener on Button.onAction
    @FXML
    public void imagenSiguiente(ActionEvent event) {
        if (numeroDeFoto <= 1) {
            numeroDeFoto = 3;
        } else {
            numeroDeFoto--;
        }
        actualizarImagen();
    }

    private void actualizarImagen() {
        // Crear un objeto Image y establecer la URL de la nueva imagen
        Image image = new Image(getClass().getResource("../images/animal" + numeroDeFoto + ".jpg").toExternalForm());

        // Establecer la nueva imagen en el ImageView
        PantallaCarrusel.setImage(image);
    }

    @FXML
    public void initialize() {
        // Llamar a actualizarImagen en la inicialización para mostrar la primera imagen
        actualizarImagen();

        // Configurar propiedades del ImageView
        PantallaCarrusel.setFitHeight(214.0);
        PantallaCarrusel.setFitWidth(215.0);
        PantallaCarrusel.setLayoutX(134.0);
        PantallaCarrusel.setLayoutY(72.0);
        PantallaCarrusel.setPickOnBounds(true);
        PantallaCarrusel.setPreserveRatio(true);
    }    
}
