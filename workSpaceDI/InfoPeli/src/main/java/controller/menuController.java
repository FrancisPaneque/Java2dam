package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ScrollPane;
import models.*;
import okhttp3.Request;
import okhttp3.Response;
import utils.CSVExporter;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import java.io.IOException;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;


/**
 * Controlador para la funcionalidad del menú de la aplicación.
 */
public class menuController {

    // Claves de la API y URL para acceder a la información de películas
    private static final String KEY_API = "bef30369a404f9a1a923bc48ffbc00bc";
    private static final String IMAGE_URL = "https://image.tmdb.org/t/p/w500";    
    
    private Stage stage;
    public static int id;
    // Elementos de la interfaz de usuario que se actualizarán
    @FXML
    private Label plataforma;

    @FXML
    private static TextArea actores;

    @FXML
    private Button busca;
    
    @FXML
    private Button exportar;

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
    private ScrollPane zonaActores;
    
    // Establece el stage
    public void setStage(Stage Stage) {
      this.stage = Stage;
    }
    
    // Establece el stage
    public void setId(int id) {
      this.id = id;
    }
    

    @FXML
    void exportar(ActionEvent event) throws IOException {
        // Obtener la película actual
    	int idpro = id;
        Movie datosPeli = getInfoMovie(idpro);
        Credits credits = getInfoCast(datosPeli.getId());
        Cast[] cast = credits.getActors();

        if (datosPeli != null) {
            // Obtener el directorio de descargas del usuario
            String downloadsDir = System.getProperty("user.home") + File.separator + "Downloads";

            // Crear el archivo en el directorio de descargas
            String fileName = downloadsDir + File.separator + "datos_pelicula.csv";
            File file = new File(fileName);

            // Exportar los datos de la película al archivo CSV en el directorio de descargas
            try {
                CSVExporter.exportMovieData(file.getAbsolutePath(), datosPeli, cast);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Éxito");
                alert.setHeaderText(null);
                alert.setContentText("Los datos de la película se han exportado correctamente en el directorio de descargas.");
                alert.showAndWait();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Ocurrió un error al exportar los datos de la película.");
                alert.showAndWait();
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pueden exportar los datos de la película porque no se ha encontrado información.");
            alert.showAndWait();
        }
    }

    @FXML
    public void initialize() throws IOException{        
    	// Obtiene la palabra de búsqueda desde el campo de texto
            try {
                // Obtiene la información de la película mediante la API 
                Movie datosPeli = getInfoMovie(id);
            	Credits credits = getInfoCast(datosPeli.getId());
            	Cast[] cast = credits.getActors();
            	Crew[] crew = credits.getCrew();
            	Genres[] genero = datosPeli.getGenres();
                // Actualiza la interfaz de usuario con la información obtenida
                updateUI(datosPeli, actores, cast, crew, genero, titulo, fechaEstreno, sinopsis, cartel, lengua, directores, generos, guionistas, duracion, puntuacion, titulo2, zonaActores);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }
    /**
     * Obtiene información sobre una película a partir de la API de themoviedb.org.
     *
     * @param palabraBusqueda Término de búsqueda para la película.
     * @return Información de la película obtenida de la API.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private static Movie getInfoMovie(int id) {
    	Movie movie = null;
    	OkHttpClient client = new OkHttpClient();

    	Request request = new Request.Builder()
    	  .url("https://api.themoviedb.org/3/movie/" + id + "?language=es-ES&api_key=bef30369a404f9a1a923bc48ffbc00bc")
    	  .get()
    	  .addHeader("accept", "application/json")
    	  .build();

        // Ejecuta la solicitud HTTP y obtiene la respuesta
        try (Response response = client.newCall(request).execute()) {
            // Verifica si la solicitud fue exitosa (código de estado 200)
            if (!response.isSuccessful()) {
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error: ");
                alert.setContentText("Reinice la aplicacion: conexión nula");
                alert.showAndWait();
                throw new IOException("Error en la solicitud: " + response);
                
            }

            // Obtiene el cuerpo de la respuesta
            String responseBody = response.body().string();

            // Utiliza Gson para convertir el cuerpo de la respuesta a un objeto Movie
            Gson gson = new Gson();
            movie = gson.fromJson(responseBody, Movie.class);
        } catch (IOException e) {
        	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error: ");
            alert.setContentText("Not Found. Película no encontrada o conexión nula");
            alert.showAndWait();
			e.printStackTrace();
		}
        return movie;
    }

    /**
     * Obtiene información sobre el elenco de una película a partir de la API de themoviedb.org.
     *
     * @param id Identificador de la película.
     * @return Información del elenco obtenida de la API.
     * @throws IOException Si ocurre un error de entrada/salida durante la solicitud HTTP.
     */
    private static Credits getInfoCast(int id) throws IOException {
    	OkHttpClient client = new OkHttpClient();

        // Construye la URL para la solicitud de elenco
        String url = "https://api.themoviedb.org/3/movie/120/credits?api_key=bef30369a404f9a1a923bc48ffbc00bc";

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
    private static void updateUI(Movie datosPeli,TextArea actores, Cast[] cast, Crew[] crew, Genres[] generos, Label titulo, Label fechaDeEstreno, TextArea sinopsis, ImageView cartel, Label lengua,
    	 Label directores, Label genero, Label guionistas, Label duracion, Label puntuacion, Label titulo2, ScrollPane zonaActores) {
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
            
            //Actualiza todos los actores
            // Se llama al método imprimirPeliculas para obtener el HBox con las imágenes y títulos de los actores.
            HBox actoresBox;
            try {
                actoresBox = imprimirActores(cast);
                // Se agrega el HBox de actores al contenido del ScrollPane existente.
                zonaActores.setContent(actoresBox);
            } catch (IOException e) {
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Error: ");
                alert.setContentText("No se encontraron actores para esta pelicula");
                alert.showAndWait();
                actoresBox = null;
            }          
            
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
    
    /**
     * Método para imprimir las imágenes y títulos de las películas en un HBox.
     *
     * @param actores Arreglo de actores para mostrar.
     * @return HBox que contiene las imágenes y títulos de las películas.
     * @throws IOException Si hay un problema al cargar las imágenes.
     */
    private static HBox imprimirActores(Cast[] actores) throws IOException {
        // Se crea un HBox para contener las imágenes y títulos de los actores.
        HBox hbox = new HBox();

        // Se itera sobre el arreglo de actores para crear y agregar las imágenes y títulos al HBox.
        for (int i = 0; i < actores.length; i++) {
        	if( actores[i].getKnownForDepartment().equals("Acting") && actores[i].getProfilePath() != null) {
        		String imageUrl = "https://image.tmdb.org/t/p/w500/" + actores[i].getProfilePath();
	            System.out.println(actores[i].getProfilePath());
	            // Se crea una ImageView para mostrar la imagen del actor.
	            ImageView imageView = new ImageView();
	            Image image = new Image(imageUrl);
	            imageView.setImage(image);
	            imageView.setFitWidth(70); // Establece el ancho deseado
	            imageView.setFitHeight(95); // Establece la altura deseada
	
	            // Se crea una etiqueta para mostrar el nombre del actor.
	            String nombreActor = actores[i].getName();
	            int indiceEspacio = nombreActor.indexOf(' ');
	            String textoDespuesEspacio = nombreActor.substring(indiceEspacio + 1, indiceEspacio + 4);
	            // Construir el texto completo
	            String textoCompleto = nombreActor.substring(0, indiceEspacio + 1) + textoDespuesEspacio;
	            // Crear el label con el texto completo
	            Label labelActor = new Label(textoCompleto + ".");
	
	            // Se crea un VBox para contener la imagen y el nombre del actor.
	            VBox vbox = new VBox();
	            vbox.getChildren().addAll(imageView, labelActor);
	            vbox.setSpacing(15); // Espacio entre la imagen y el nombre
	
	            // Se añade el VBox al HBox.
	            hbox.getChildren().add(vbox);
        	}
        }

        // Se devuelve el HBox con las imágenes y títulos de los actores.
        return hbox;
    }

    
}