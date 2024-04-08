package Utilidades;

import AADD.Conexion.*;
import Pelicula.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;


public class Utilidades {
	
	//Lista que contiene las peliculas y sus respectivos campos
	public static List<Pelicula> peliculas = new ArrayList<>();
	
	/**
	 * Metodo que realiza la consulta en la base de datos sakila en la tabla film
	 * @return resulset
	 */
	public static ResultSet realizeSelect() {
		//Resultado
		ResultSet rs = null;
		//Crea la conexion
		Connection conexion = null;
		//Declaramos la consulta que vamos a realizar
		String sqlQuery = "SELECT film_id, release_year, length, title, description FROM film ;";
		
		try {
			//Iniciamos la conexion
			conexion = AADD.Conexion.Conexion.conexion();
			//Declaramos el statement
			Statement statement = conexion.createStatement();
			//Declaramos la query
			rs = statement.executeQuery(sqlQuery);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	/**
	 * metodo que añade a la lista pelicula los datos del resultset rs
	 * @param rs
	 */
	public static void añadePeliculasLista(ResultSet rs){
		
		try {
			while ((rs).next()) {
				Pelicula pelicula = new Pelicula((rs).getInt("film_id"), (rs).getString("title"),(rs).getInt("release_year"), (rs).getInt("length"), (rs).getString("description"));
				peliculas.add(pelicula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertarFilm(JTextField textId, JTextField textEstreno, JTextField textDuracion,
            JTextField textTitulo, JTextArea textAreaDescripcion) {

        // Obtener los valores de los campos de texto y área de texto
        int filmId = Integer.parseInt(textId.getText());
        int releaseYear = Integer.parseInt(textEstreno.getText());
        int length = Integer.parseInt(textDuracion.getText());
        String title = textTitulo.getText();
        String description = textAreaDescripcion.getText();

        // Obtener la conexión desde la clase Conexion
        try (Connection connection = Conexion.conexion();
             PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO film (film_id, release_year, length, title, description,language_id) VALUES (?, ?, ?, ?, ?,?)")) {

            // Establecer los parámetros para la declaración preparada
            preparedStatement.setInt(1, filmId);
            preparedStatement.setInt(2, releaseYear);
            preparedStatement.setInt(3, length);
            preparedStatement.setString(4, title);
            preparedStatement.setString(5, description);
            preparedStatement.setInt(6, 1);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();
            System.out.println("Inserción exitosa en la tabla film.");

        } catch (SQLException e) {
            System.err.println("Error al insertar en la tabla film: " + e.getMessage());
        }
    }
    
}