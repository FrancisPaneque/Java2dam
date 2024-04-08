package Utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase es el model de las clases del gimnasio
 * @author Alvaro
 *
 */
public class Clases {
	
	private String nombre;
	private String profesor;
	private String turno;
	
	/**
	 * Constructor de la clase Clases
	 * @param nombre
	 * @param profesor
	 * @param tiempo
	 */
	public Clases(String nombre, String profesor, String tiempo) {
		setNombre(nombre);
		setProfesor(profesor);
		setTurno(tiempo);
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the profesor
	 */
	public String getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the turno
	 */
	public String getTurno() {
		return turno;
	}

	/**
	 * @param turno the turno to set
	 */
	public void setTurno(String turno) {
		this.turno = turno;
	}



	/**
	 * Lista donde guardamos todas las clases existen
	 */
	public static List<Clases> listaClase = new ArrayList<>();
	
	/**
	 * Añadir las clases a la lista
	 * @param clase
	 */
	public static void addClase(Clases clase) {
		listaClase.add(clase);
	}

}
