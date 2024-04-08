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
import models.*;

public class menuController {
	
	private static final String API_KEY = "1590f2a35c71ac72c9821b190ae1a26a";
    private static final String BASE_URL = "https://api.themoviedb.org/3/search/movie";
    private static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";
	
    @FXML
    private ImageView busca;

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

    @FXML
	void buscar(ActionEvent e) {
		String palabraBusqueda = buscador.getText();
        if (!palabraBusqueda.isEmpty()) {
            try {
                InfoPeli movieInfo = getInfoPeli(palabraBusqueda);
                updateUI(movieInfo, titulo, fechaEstreno, sinopsis, cartel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
	}

	private InfoPeli getInfoPeli(String palabraBusqueda) throws ClientProtocolException, IOException {
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
        return gson.fromJson(responseBody, InfoPeli.class);
	}
	
    private void updateUI(InfoPeli movieInfo, Label titleLabel, Label summaryLabel, Label releaseDateLabel, ImageView cartel) {
    	titleLabel.setText("Titulo: " + movieInfo.getTitulo());
		summaryLabel.setText("Resumen: " + movieInfo.getResumen());
		releaseDateLabel.setText("Fecha de estreno: " + movieInfo.getFechaDeEstreno());
	
		String poster = movieInfo.getCartel();
		if (poster != null && !poster.isEmpty()) {
			Image posterImage = new Image(IMAGE_BASE_URL + poster);
			cartel.setImage(posterImage);
		}
	}
    
}