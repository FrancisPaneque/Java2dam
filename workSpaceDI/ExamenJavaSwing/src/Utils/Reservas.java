package Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase model de Reservas
 * @author Alvaro
 *
 */

public class Reservas {
	
	private String nombre;
	private String apellidos;
	private String clase;
	private String turno;
	
	
	/**
	 * Constructor de la clase reserva donde establecemos los datos de las reservas
	 * @param nombre
	 * @param apellidos
	 * @param clase
	 * @param turno
	 */
	public Reservas(String nombre, String apellidos, String clase, String turno) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.clase = clase;
		this.turno = turno;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the clase
	 */
	public String getClase() {
		return clase;
	}

	/**
	 * @param clase the clase to set
	 */
	public void setClase(String clase) {
		this.clase = clase;
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
	 * Lista donde guardamos todas las reservas de los clientes
	 */
	public static List<Reservas> listaReserva = new ArrayList<>();
	
	/**
	 * Añade el administrados que pasamos por parametro
	 * @param reserva
	 */
	public static void addReserva(Reservas reserva) {
		listaReserva.add(reserva);
	}

}
