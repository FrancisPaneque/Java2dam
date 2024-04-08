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
public class Actor {
	
	@Id
    @Column(name = "nombre_actor")
    private String nombreActor;

    @Column(name = "id_pelicula")
    private int idPelicula;

    // Otros campos y relaciones según sea necesario

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL)
    private Set<PeliculaActor> peliculas;
    
    // Getters & setters
    
	public String getNombreActor() {
		return nombreActor;
	}

	public void setNombreActor(String nombreActor) {
		this.nombreActor = nombreActor;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Set<PeliculaActor> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<PeliculaActor> peliculas) {
		this.peliculas = peliculas;
	}

	
}
