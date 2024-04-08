package Utils;

import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase es la model del administrador, donde se guardan todos los datos de los administradores
 * @author Alvaro
 *
 */
public class Administrador {
	
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String Email;
	private String contrasenia;
	
	/**
	 * Constructor de la clase administrador donde establecemos los datos del administrador
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param Email
	 * @param contrasenia
	 */
	public Administrador(String nombre, String apellidos, String fechaNacimiento, String Email,String contrasenia) {
	setNombre(nombre);
	setApellidos(apellidos);
	setFechaNacimiento(fechaNacimiento);
	setEmail(Email);
	setContrasenia(contrasenia);
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
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * @param contrasenia the contrasenia to set
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * @return the listaAdmins
	 */
	public static List<Administrador> getListaAdmins() {
		return listaAdmins;
	}

	/**
	 * Lista donde guardamos todos los administradores que existen
	 */
	public static List<Administrador> listaAdmins = new ArrayList<>();
	
	/**
	 * Añade el administrados que pasamos por parametro
	 * @param admin
	 */
	public static void addAdministrador(Administrador admin) {
		listaAdmins.add(admin);
	}
	
	/**
	 * Devuelve el tamaño de la lista
	 * @return int
	 */
	public static int tamanioLista() {
		return listaAdmins.size();
	}
	
	/**
	 * Busca en la lista de los administradores que sea igual al email que se le pasa por parametro
	 * @param email
	 * @return cliente
	 */
	public static int buscaAdmin(String email) {
		int cliente = 0;
		
		for(int i = 0; i < listaAdmins.size(); i++) {
			
			String correo = listaAdmins.get(i).getEmail();
			if (correo.equalsIgnoreCase(email)) {
				
				cliente = i;
			}
		}
		return cliente;
	}
	
	/**
	 * Mira si existe el admin en la lista
	 * @param email
	 * @return true si existe, false si no existe
	 */
	public static boolean existeAdmin(String email) {
		for(int i = 0; i < listaAdmins.size(); i++) {
			
			String correo = listaAdmins.get(i).getEmail();
			if (correo.equalsIgnoreCase(email)) {
				return true;	
			}
		}
		
		return false;
	}

}
