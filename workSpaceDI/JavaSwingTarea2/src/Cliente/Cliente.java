package Cliente;

public class Cliente {
	
	private String nombre;
	private String apellidos;
	private int edad;
	private String provincia;
	
	public Cliente(String nombre, String apellidos, int edad, String provincia) {
		setNombre(nombre);
	    setApellidos(apellidos);
	    setEdad(edad);
	    setProvincia(provincia);
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", provincia=" + provincia
				+ "]" + "\n";
	} 
	
	
	
}
