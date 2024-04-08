package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Plataformas {
	
	@Id
    @Column(name = "localizacion")
    private String localizacion;

    @Column(name = "id_pelicula")
    private int idPelicula;

    // Otros campos y relaciones según sea necesario

    @OneToMany(mappedBy = "plataforma", cascade = CascadeType.ALL)
    private Set<PeliculaPlataformas> peliculas;
    
    // Getters & setters

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Set<PeliculaPlataformas> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<PeliculaPlataformas> peliculas) {
		this.peliculas = peliculas;
	}
	
}
