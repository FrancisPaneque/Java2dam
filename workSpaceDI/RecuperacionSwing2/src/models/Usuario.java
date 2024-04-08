package models;


public class Usuario {
	
	private String nombreUsuario;
	private String apellidos;
	private String telefono;
	private String mail;
	private String contrasenia;
	private String metodoContacto;
	
	public Usuario(String nombreUsuario, String apellidos, String telefono, String mail, String contrasenia,
			String metodoContacto) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.mail = mail;
		this.contrasenia = contrasenia;
		this.metodoContacto = metodoContacto;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getMetodoContacto() {
		return metodoContacto;
	}

	public void setMetodoContacto(String metodoContacto) {
		this.metodoContacto = metodoContacto;
	}

}
