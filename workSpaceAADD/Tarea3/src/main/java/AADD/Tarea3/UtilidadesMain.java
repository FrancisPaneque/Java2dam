package AADD.Tarea3;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import Pelicula.Pelicula;
import Utilidades.Utilidades;

public class UtilidadesMain {
	
	//Variable que controla la posicion de la lista de peliculas
	public static int posicionListaPeliculas;
	
	/**
	 * metodo que muestra la primera pelicula de la lista peliculas
	 * @param textId
	 * @param textTitulo
	 * @param textEstreno
	 * @param textDuracion
	 * @param textAreaDescripcion
	 */
	public static void primeraPelicula(JTextField textId, JTextField textTitulo, JTextField textEstreno, JTextField textDuracion, JTextArea textAreaDescripcion) {
		//Tomamos la primera pelicula
		Pelicula primeraPeli = Utilidades.peliculas.get(0);
		//Rellenenamos los coampos del interfaz con los datos de la pelicula
		textId.setText(Integer.toString(primeraPeli.getFilm_id()));
		textTitulo.setText(primeraPeli.getTitle());
		textEstreno.setText(Integer.toString(primeraPeli.getYear()));
		textDuracion.setText(Integer.toString(primeraPeli.getLenght()));
		textAreaDescripcion.setText(primeraPeli.getDescription());
		
		posicionListaPeliculas = 0;
	}
	
	/**
	 * metodo que muestra la ultima pelicula de la lista peliculas
	 * @param textId
	 * @param textTitulo
	 * @param textEstreno
	 * @param textDuracion
	 * @param textAreaDescripcion
	 */
	public static void ultimaPelicula(JTextField textId, JTextField textTitulo, JTextField textEstreno, JTextField textDuracion, JTextArea textAreaDescripcion) {
		//Tomamos la primera pelicula
		Pelicula ultimaPeli = Utilidades.peliculas.get(Utilidades.peliculas.size() - 1);
		//Rellenenamos los coampos del interfaz con los datos de la pelicula
		textId.setText(Integer.toString(ultimaPeli.getFilm_id()));
		textTitulo.setText(ultimaPeli.getTitle());
		textEstreno.setText(Integer.toString(ultimaPeli.getYear()));
		textDuracion.setText(Integer.toString(ultimaPeli.getLenght()));
		textAreaDescripcion.setText(ultimaPeli.getDescription());
		
		posicionListaPeliculas = Utilidades.peliculas.size() - 1;
	}
	
	public static void siguientePelicula(JTextField textId, JTextField textTitulo, JTextField textEstreno, JTextField textDuracion, JTextArea textAreaDescripcion) {
		Pelicula ultimaPeli = null;
		//Tomamos la primera pelicula
		if (posicionListaPeliculas != 999) {
			ultimaPeli = Utilidades.peliculas.get(posicionListaPeliculas += 1);
		} else {
			ultimaPeli = Utilidades.peliculas.get(posicionListaPeliculas = 0);
		}
		//Rellenenamos los coampos del interfaz con los datos de la pelicula
		textId.setText(Integer.toString(ultimaPeli.getFilm_id()));
		textTitulo.setText(ultimaPeli.getTitle());
		textEstreno.setText(Integer.toString(ultimaPeli.getYear()));
		textDuracion.setText(Integer.toString(ultimaPeli.getLenght()));
		textAreaDescripcion.setText(ultimaPeli.getDescription());
		
	}
	
	public static void anteriorPelicula(JTextField textId, JTextField textTitulo, JTextField textEstreno, JTextField textDuracion, JTextArea textAreaDescripcion) {
		Pelicula ultimaPeli = null;
		//Tomamos la primera pelicula
		if (posicionListaPeliculas != 0) {
			ultimaPeli = Utilidades.peliculas.get(posicionListaPeliculas -= 1);
		} else {
			ultimaPeli = Utilidades.peliculas.get(posicionListaPeliculas = 999);
		}
		//Rellenenamos los coampos del interfaz con los datos de la pelicula
		textId.setText(Integer.toString(ultimaPeli.getFilm_id()));
		textTitulo.setText(ultimaPeli.getTitle());
		textEstreno.setText(Integer.toString(ultimaPeli.getYear()));
		textDuracion.setText(Integer.toString(ultimaPeli.getLenght()));
		textAreaDescripcion.setText(ultimaPeli.getDescription());
		
	}
	
	public static void camposVacios(JTextField textId, JTextField textTitulo, JTextField textEstreno, JTextField textDuracion, JTextArea textAreaDescripcion) {
		textId.setText("");
		textTitulo.setText("");
		textEstreno.setText("");
		textDuracion.setText("");
		textAreaDescripcion.setText("");
	}
}
