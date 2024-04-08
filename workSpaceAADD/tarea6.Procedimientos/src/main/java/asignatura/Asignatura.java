package asignatura;

public class Asignatura {
	
	private String codAsignatura;
	private String nombreAsignatura;
	
	public Asignatura(String codAsignatura, String nombreAsignatura) {
		setCodAsignatura(codAsignatura);
		setNombreAsignatura(nombreAsignatura);
	}

	public String getCodAsignatura() {
		return codAsignatura;
	}

	public void setCodAsignatura(String codAsignatura) {
		this.codAsignatura = codAsignatura;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}
	
	
	
}
