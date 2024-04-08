package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compañia {
	
	@Id
    @Column(name = "genero")
    private String genero;

    @Column(name = "id_pelicula")
    private int idPelicula;

    // Otros campos y relaciones según sea necesario

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private Set<PeliculaGenero> peliculas;
    
    // Getters & setters
    
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Set<PeliculaGenero> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<PeliculaGenero> peliculas) {
		this.peliculas = peliculas;
	}
    
}
