package Usuarios;

public class Usuario {

	private String nombre;
	private String apellidos;
	private String user;
	
	public Usuario (String nombre, String apellidos) {
		setNombre(nombre);
		setApellidos(apellidos);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
