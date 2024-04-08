package profesor;

public class Profesor {
	
	private String NIF;
	private String nombre;
	private String especialidad;
	private int telefono;
	private int IdProfesor;
	
	public Profesor(String Nif, String nombre, String especialidad, int idProfesor) {
		setNIF(Nif);
		setNombre(nombre);
		setEspecialidad(especialidad);
	}
	
	public int getIdProfesor() {
		return IdProfesor;
	}



	public void setIdProfesor(int idProfesor) {
		IdProfesor = idProfesor;
	}



	public String getNIF() {
		return NIF;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	
}
