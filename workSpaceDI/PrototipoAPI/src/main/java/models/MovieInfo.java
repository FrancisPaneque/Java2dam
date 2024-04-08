package models;

public class MovieInfo {
	
	private String titulo;
	private String fechaDeEstreno;
	private String resumen;
	private String poster;
	
	public MovieInfo(String titulo, String fechaDeEstreno, String resumen, String poster) {
		super();
		this.titulo = titulo;
		this.fechaDeEstreno = fechaDeEstreno;
		this.resumen = resumen;
		this.poster = poster;
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

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	

}
