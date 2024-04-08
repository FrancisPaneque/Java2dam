package models;

public class Clase {
	
	private String nombre;
	private String profesor;
	private String turno;
	
	public Clase (String nombre, String profesor, String turno){
		setNombre(nombre);
		setProfesor(profesor);
		setTurno(turno);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	
}
