package models;

public class InfoPeli {
	
	private String titulo;
	private String fechaDeEstreno;
	private String sinopsis;
	private String cartel;
	
	public InfoPeli(String titulo, String fechaDeEstreno, String sinopsis, String cartel) {
		super();
		setTitulo(titulo);
		setFechaDeEstreno(fechaDeEstreno);
		setSinopsis(sinopsis);
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

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getCartel() {
		return cartel;
	}

	public void setCartel(String cartel) {
		this.cartel = cartel;
	}
	
	

}

