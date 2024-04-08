package models;

public class Usuario {
	
	private String nombre;
	private String mail;
	private String sexo;
	private int numero;
	
	public Usuario(String nombre, String mail, String sexo, int numero) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.sexo = sexo;
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	
}
