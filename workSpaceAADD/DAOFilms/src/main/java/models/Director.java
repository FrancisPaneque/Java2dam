package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Director {
	
	@Id
    @Column(name = "nombre_director")
    private String nombreDirector;

    @Column(name = "id_pelicula")
    private int idPelicula;

    // Otros campos y relaciones según sea necesario

    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL)
    private Set<PeliculaDirector> peliculas;

    // Getters & setters
    
	public String getNombreDirector() {
		return nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Set<PeliculaDirector> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<PeliculaDirector> peliculas) {
		this.peliculas = peliculas;
	}
    
}
