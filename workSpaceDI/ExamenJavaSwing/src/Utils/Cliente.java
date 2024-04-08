package Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase del model Cliente 
 * @author Alvaro
 *
 */
public class Cliente {
	
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String Email;
	private String contrasenia;
	
	/**
	 * Constructor Cliente
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param Email
	 * @param contrasenia
	 */
	public Cliente(String nombre, String apellidos, String fechaNacimiento, String Email,String contrasenia) {
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
	 * Lista donde guardamos todos los Clientes que existen
	 */
	public static List<Cliente> listaCliente = new ArrayList<>();
	
	/**
	 * Añade el Cliente que pasamos por parametro a la lista
	 * @param cliente
	 */
	public static void addCliente(Cliente cliente) {
		listaCliente.add(cliente);
	}
	
	/**
	 * Busca en la lista de los cliente que sea igual al email que se le pasa por parametro
	 * @param email
	 * @return cliente
	 */
	
	public static int buscaCliente(String email) {
		int cliente = 0;
		
		for(int i = 0; i < listaCliente.size(); i++) {
			
			String correo = listaCliente.get(i).getEmail();
			if (correo.equalsIgnoreCase(email)) {
				
				cliente = i;
			}
		}
		return cliente;
	}
	
	/**
	 * Mira si existe el Cliente en la lista 
	 * @param email
	 * @return true si existe, false si no existe
	 */
	public static boolean existeCliente(String email) {
		for(int i = 0; i < listaCliente.size(); i++) {
			
			String correo = listaCliente.get(i).getEmail();
			if (correo.equalsIgnoreCase(email)) {
				return true;	
			}
		}
		
		return false;
	}
	
	/**
	 * Devuelve el cliete que este en la posicion que el parametro
	 * @param  i numero en la lista
	 * @return cliente
	 */
	public static Cliente devuelveCliente(int i) {
		return listaCliente.get(i);
	}
	
	public static int tamanioLista() {
		return listaCliente.size();
		
	}

}
