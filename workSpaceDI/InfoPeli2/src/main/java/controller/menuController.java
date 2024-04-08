package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.*;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import java.io.IOException;


/**
 * Controlador para la funcionalidad del menú de la aplicación.
 */
public class menuController {

    // Claves de la API y URL para acceder a la información de películas
    private static final String KEY_API = "bef30369a404f9a1a923bc48ffbc00bc";
    private static final String URL_MOVIE = "https://api.themoviedb.org/3/search/movie";
    private static final String URL_CAST = "https://api.themoviedb.org/3/movie";
    private static final String IMAGE_URL = "https://image.tmdb.org/t/p/w500";    

    // Elementos de la interfaz de usuario que se actualizarán
    @FXML
    private Label plataforma;

    @FXML
    private TextArea actores;

    @FXML
    private Button busca;

    @FXML
    private TextField buscador;

    @FXML
    private ImageView cartel;

    @FXML
    private Label directores;

    @FXML
    private Label lengua;

    @FXML
    private Label fechaEstreno;

    @FXML
    private Label generos;

    @FXML
    private Label guionistas;

    @FXML
    private Label duracion;

    @FXML
    private Label puntuacion;

    @FXML
    private TextArea sinopsis;

    @FXML
    private Label titulo;

    @FXML
    private Label titulo2;

    @FXML
    private ImageView imgActor1;

    @FXML
    private Label nombreActor1;


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
                Movie datosPeli = getInfoMovie(Integer.parseInt(palabraBusqueda));
            	Credits credits = getInfoCast(datosPeli.getId());
            	Cast[] cast = credits.getActors();
            	Crew[] crew = credits.getCrew();
            	Genres[] genero = datosPeli.getGenres();
                // Actualiza la interfaz de usuario con la información obtenida
                updateUI(datosPeli, actores, cast, crew, genero, titulo, fechaEstreno, sinopsis, cartel, lengua, directores, generos, guionistas, duracion, puntuacion, titulo2, imgActor1, nombreActor1);
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
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private Movie getInfoMovie(int id) throws IOException {
    	OkHttpClient client = new OkHttpClient();

    	Request request = new Request.Builder()
    	  .url("https://api.themoviedb.org/3/movie/"+ id +"?language=en-US")
    	  .get()
    	  .addHeader("accept", "application/json")
    	  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiZWYzMDM2OWE0MDRmOWExYTkyM2JjNDhmZmJjMDBiYyIsInN1YiI6IjY1NzgxNTM4YWY1OGNiMDEyMzZjNTI1MSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.bCxvNQumYvyL9RcsBFeumwiVcdcUIWmhdApZAFLI1oA")
    	  .build();

        // Ejecuta la solicitud HTTP y obtiene la respuesta
        try (Response response = client.newCall(request).execute()) {
            // Verifica si la solicitud fue exitosa (código de estado 200)
            if (!response.isSuccessful()) {
                throw new IOException("Error en la solicitud: " + response);
            }

            // Obtiene el cuerpo de la respuesta
            String responseBody = response.body().string();

            // Utiliza Gson para convertir el cuerpo de la respuesta a un objeto Movie
            Gson gson = new Gson();
            return gson.fromJson(responseBody, Movie.class);
        }
    }

    /**
     * Obtiene información sobre el elenco de una película a partir de la API de themoviedb.org.
     *
     * @param id Identificador de la película.
     * @return Información del elenco obtenida de la API.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private Credits getInfoCast(int id) throws IOException {
    	OkHttpClient client = new OkHttpClient();

        // Construye la URL para la solicitud de elenco
        String url = "https://api.themoviedb.org/3/movie/" + id + "/credits?api_key=" + KEY_API;

        // Crea la solicitud
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Realiza la solicitud y obtiene la respuesta
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error en la solicitud: " + response);
            }

            // Convierte la respuesta a una cadena JSON
            String responseBody = response.body().string();

            // Utiliza Gson para convertir la cadena JSON a un objeto MovieCredits
            Gson gson = new Gson();
            return gson.fromJson(responseBody, Credits.class);
        }
    }



    /**
     * Actualiza la interfaz de usuario con la información de la película.
     *
     * @param infoPeli Información de la película a mostrar.
     * @param titulo    Etiqueta para mostrar el título de la película.
     * @param overview  Etiqueta para mostrar la sinopsis de la película.
     * @param sinopsis   Etiqueta para mostrar la fecha de estreno de la película.
     * @param poster_path    ImageView para mostrar el cartel de la película.
     */
    private void updateUI(Movie datosPeli,TextArea actores, Cast[] cast, Crew[] crew, Genres[] generos, Label titulo, Label fechaDeEstreno, TextArea sinopsis, ImageView cartel, Label lengua,
    		Label directores, Label genero, Label guionistas, Label duracion, Label puntuacion, Label titulo2, ImageView imgActor, Label nombreActor) {
        // Actualiza los elementos de la interfaz con la información de la película
        if (datosPeli != null) {
        	//Actualiza titulo
            titulo.setText(datosPeli.getTitle());
            //Actualiza fecha de estreno
            fechaDeEstreno.setText(datosPeli.getRelease_date());
            //Actualiza lenguaje original
            lengua.setText(datosPeli.getOriginal_language());
            // Actualiza los directores de la película
            String director = "";
            for (Crew direccion : crew) {
                if (direccion.getJob().equals("Director")) {
                    director += direccion.getName() + ", "; // Agregar una coma después de cada nombre de director
                }
            }
            // Si hay al menos un director, eliminamos la coma adicional al final
            if (!director.isEmpty()) {
                director = director.substring(0, director.length() - 2);
            }
            directores.setText(director);

            // Actualiza los guionistas
            String guionista = "";
            for (Crew guion : crew) {
                if (guion.getJob().equals("Screenplay")) {
                    guionista += guion.getName() + ", "; // Agregar una coma después de cada nombre de guionista
                }
            }
            // Si hay al menos un guionista, eliminamos la coma adicional al final
            if (!guionista.isEmpty()) {
                guionista = guionista.substring(0, guionista.length() - 2);
            }
            guionistas.setText(guionista);
            //Actualiza duracion
            duracion.setText(Integer.toString(datosPeli.getRuntime()) + " min");
            //Actualiza reparto
            String posterAct = cast[0].getProfilePath();
            if (posterAct != null && !posterAct.isEmpty()) {
                Image posterImage = new Image(IMAGE_URL + posterAct);
                imgActor.setImage(posterImage);
            }
            nombreActor.setText(cast[0].getName());
            //Actualiza generos
            String genre = "";
            for (Genres genres : generos) {
                genre += genres.getName() + ", "; // Agregar una coma después de cada nombre de género
            }
            // Si hay al menos un género, eliminamos la coma adicional al final
            if (!genre.isEmpty()) {
                genre = genre.substring(0, genre.length() - 2);
            }
            genero.setText(genre);
            //Actualiza sinopsis
            sinopsis.setText(datosPeli.getOverview());
            //Actualiza puntuacion
            puntuacion.setText(Double.toString(datosPeli.getVote_average()).substring(0, 3));
            // Obtiene la URL del cartel de la película y la muestra en la ImageView
            String poster = datosPeli.getPoster_path();
            if (poster != null && !poster.isEmpty()) {
                Image posterImage = new Image(IMAGE_URL + poster);
                cartel.setImage(posterImage);
            }
            //Actualiza el titulo2
            titulo2.setText(datosPeli.getTitle());
        }
    }

    private void actualizaActor(ImageView imgActor, Label nombreActor, Cast[] actores) {
    	String poster = actores[0].getProfilePath();
        if (poster != null && !poster.isEmpty()) {
            Image posterImage = new Image(IMAGE_URL + poster);
            imgActor.setImage(posterImage);
        }
        nombreActor.setText(actores[0].getName());
    }
}