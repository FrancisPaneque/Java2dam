package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.InfoPeli;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Controlador para la funcionalidad del menú de la aplicación.
 */
public class menuController {

    // Claves de la API y URL para acceder a la información de películas
    private static final String KEY_API = "bef30369a404f9a1a923bc48ffbc00bc";
    private static final String URL = "https://api.themoviedb.org/3/search/movie";
    private static final String IMAGE_URL = "https://image.tmdb.org/t/p/w500";

    // Elementos de la interfaz de usuario que se actualizarán
    @FXML
    private Button busca;

    @FXML
    private TextField buscador;

    @FXML
    private ImageView cartel;

    @FXML
    private Label fechaEstreno;

    @FXML
    private Label sinopsis;

    @FXML
    private Label titulo;

    /**
     * Realiza una búsqueda de película al hacer clic en el botón de búsqueda.
     *
     * @param e Evento de acción generado por el clic en el botón de búsqueda.
     */
    @FXML
    void buscar(ActionEvent e) {
        // Obtiene la palabra de búsqueda desde el campo de texto
        String palabraBusqueda = buscador.getText();
        if (!palabraBusqueda.isEmpty()) {
            try {
                // Obtiene la información de la película mediante la API
                InfoPeli infoPeli = getInfoPeli(palabraBusqueda);
                // Actualiza la interfaz de usuario con la información obtenida
                updateUI(infoPeli, titulo, fechaEstreno, sinopsis, cartel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Obtiene información sobre una película a partir de la API de themoviedb.org.
     *
     * @param palabraBusqueda Término de búsqueda para la película.
     * @return Información de la película obtenida de la API.
     * @throws ClientProtocolException Si ocurre un error en el protocolo de cliente durante la solicitud HTTP.
     * @throws IOException            Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private InfoPeli getInfoPeli(String palabraBusqueda) throws ClientProtocolException, IOException {
        // Construye la URL de la API con la clave y la palabra de búsqueda
        String apiUrl = String.format("%s?api_key=%s&query=%s", URL, KEY_API, palabraBusqueda);
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);

        // Ejecuta la solicitud HTTP y obtiene la respuesta
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        // Procesa la respuesta para obtener el cuerpo de la misma
        try (BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()))) {
            StringBuilder responseStringBuilder = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                responseStringBuilder.append(linea);
            }

            String responseBody = responseStringBuilder.toString();

            // Utiliza Gson para convertir el cuerpo de la respuesta a un objeto InfoPeli
            Gson gson = new Gson();
            return gson.fromJson(responseBody, InfoPeli.class);
        }
    }

    /**
     * Actualiza la interfaz de usuario con la información de la película.
     *
     * @param infoPeli Información de la película a mostrar.
     * @param titulo    Etiqueta para mostrar el título de la película.
     * @param sinopsis  Etiqueta para mostrar la sinopsis de la película.
     * @param estreno   Etiqueta para mostrar la fecha de estreno de la película.
     * @param cartel    ImageView para mostrar el cartel de la película.
     */
    private void updateUI(InfoPeli infoPeli, Label titulo, Label sinopsis, Label estreno, ImageView cartel) {
        // Actualiza los elementos de la interfaz con la información de la película
        if (infoPeli != null) {
            titulo.setText(infoPeli.getTitulo());
            sinopsis.setText(infoPeli.getSinopsis());
            estreno.setText(infoPeli.getFechaDeEstreno());

            // Obtiene la URL del cartel de la película y la muestra en la ImageView
            String poster = infoPeli.getCartel();
            if (poster != null && !poster.isEmpty()) {
                Image posterImage = new Image(IMAGE_URL + poster);
                cartel.setImage(posterImage);
            }
        }
    }
}