package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SuperUsuario {
	
	// Esto son los diferentes campos que tienen la tabla SuperUsuario
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private String user;
	
	// Es el constructor del objeto con las variables rellenas
	public SuperUsuario(String nombre, String apellidos, String user) {
		setNombre(nombre);
		setApellidos(apellidos);
		setUser(user);
	}
	
	// Es el contructor vacio
	public SuperUsuario() {
		
	}
	
	// Estos son los getters and setters
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
