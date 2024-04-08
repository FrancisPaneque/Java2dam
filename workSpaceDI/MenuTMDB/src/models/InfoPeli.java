package models;

public class InfoPeli {
	
	private String titulo;
	private String fechaDeEstreno;
	private String resumen;
	private String cartel;
	
	public InfoPeli(String titulo, String fechaDeEstreno, String resumen, String cartel) {
		super();
		setTitulo(titulo);
		setFechaDeEstreno(fechaDeEstreno);
		setResumen(resumen);
		setCartel(cartel);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaDeEstreno() {
		return fechaDeEstreno;
	}

	public void setFechaDeEstreno(String fechaDeEstreno) {
		this.fechaDeEstreno = fechaDeEstreno;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getCarterl() {
		return cartel;
	}

	public void setCartel(String cartel) {
		this.cartel = cartel;
	}
	
	

}

