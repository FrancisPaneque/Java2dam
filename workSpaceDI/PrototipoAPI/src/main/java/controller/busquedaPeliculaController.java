package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.MovieInfo;

public class busquedaPeliculaController {
	
    private static final String API_KEY = "1590f2a35c71ac72c9821b190ae1a26a";
    private static final String BASE_URL = "https://api.themoviedb.org/3/search/movie";
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

	
	@FXML
	private TextField txtfBuscaPelicula;
	
	@FXML
	private Button bttnBuscar;
	
	@FXML
	private AnchorPane fondo;
	
	@FXML
	private ImageView imgPoster;
	
	@FXML
	private Label titulo;
	
	@FXML
	private Label resumen;
	
	@FXML
	private Label fechaDeEstreno;
	
	
	@FXML
	void buscar(ActionEvent e) {
		String palabraBusqueda = txtfBuscaPelicula.getText();
        if (!palabraBusqueda.isEmpty()) {
            try {
                MovieInfo movieInfo = getMovieInfo(palabraBusqueda);
                updateUI(movieInfo, titulo, fechaDeEstreno, resumen, imgPoster);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

	private MovieInfo getMovieInfo(String palabraBusqueda) throws ClientProtocolException, IOException {
        String apiUrl = String.format("%s?api_key=%s&query=%s", BASE_URL, API_KEY, palabraBusqueda);
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);
        
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
        StringBuilder responseStringBuilder = new StringBuilder();
        String linea;
        
        while ((linea = br.readLine()) != null) {
            responseStringBuilder.append(linea);
        }

        String responseBody = responseStringBuilder.toString();

        Gson gson = new Gson();
        return gson.fromJson(responseBody, MovieInfo.class);
	}
	
    private void updateUI(MovieInfo movieInfo, Label titleLabel, Label summaryLabel, Label releaseDateLabel, ImageView posterImageView) {
    	titleLabel.setText("Titulo: " + movieInfo.getTitulo());
		summaryLabel.setText("Resumen: " + movieInfo.getResumen());
		releaseDateLabel.setText("Fecha de estreno: " + movieInfo.getFechaDeEstreno());
	
		String poster = movieInfo.getPoster();
		if (poster != null && !poster.isEmpty()) {
			Image posterImage = new Image(IMAGE_BASE_URL + poster);
			posterImageView.setImage(posterImage);
		}
	}

}
