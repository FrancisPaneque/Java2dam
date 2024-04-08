package models;
	
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Usuarios {
	
	@Column(name = "correo_electronico")
	private String correo;
	
	@Column(name = "numero_telefono")
	private String numeroTlf;
	
	@Column(name = "nombre_usuario")
	private String usuario;
	
	@Column(name = "contraseña_usuario")
	private String password;
	
	@Id
	@Column(name = "id_usuario")
	private int id;
	
	public Usuarios() {
	}
	
	public Usuarios(int id, String usuario, String correo, String password, String numeroTlf) {
		setId(id);
		setUsuario(usuario);
		setCorreo(correo);
		setPassword(password);
		setNumeroTlf(numeroTlf);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the numeroTlf
	 */
	public String getNumeroTlf() {
		return numeroTlf;
	}

	/**
	 * @param numeroTlf the numeroTlf to set
	 */
	public void setNumeroTlf(String numeroTlf) {
		this.numeroTlf = numeroTlf;
	}
	
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Este metodo comprueba si las dos palabras son iguales
	 * @param cadena1
	 * @param cadena2
	 * @return true si son iguales, false si son diferentes
	 */
	public static boolean compruebaPassword(String cadena1, String cadena2) {
		if (cadena1.compareTo(cadena2) == 0) {
			return true;
		} else {
			return false;
		}
	}

}
