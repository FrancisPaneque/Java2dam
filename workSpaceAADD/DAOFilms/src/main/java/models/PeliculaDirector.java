package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pelicula_Director")
public class PeliculaDirector implements java.io.Serializable {

    @Id
    @Column(name = "id_pelicula")
    private int idPelicula;

    @Id
    @Column(name = "nombre_director")
    private String nombreDirector;

    // Otros campos según sea necesario

    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "ID", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "nombre_director", referencedColumnName = "nombre_director", insertable = false, updatable = false)
    private Director director;
    
    // Getters & setters
    
	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombreDirector() {
		return nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
    
    
}
