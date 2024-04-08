package hlc.ud04.autentificadorapp.autenticador;

public class UsuarioPassword {
	
	private String nombre;
	private String password;
	private int id;

	public UsuarioPassword(String nombre, String password, int id) {
		this.nombre = nombre;
		this.password = password;
		this.id = id;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
