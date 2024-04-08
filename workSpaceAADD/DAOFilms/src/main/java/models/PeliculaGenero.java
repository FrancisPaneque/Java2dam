package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pelicula_Genero")
public class PeliculaGenero implements java.io.Serializable {

    @Id
    @Column(name = "id_pelicula")
    private int idPelicula;

    @Id
    @Column(name = "genero")
    private String genero;

    // Otros campos según sea necesario

    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "ID", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "genero", referencedColumnName = "genero", insertable = false, updatable = false)
    private Genero generoPelicula;
    
    // Getters & setters
    
	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Genero getGeneroPelicula() {
		return generoPelicula;
	}

	public void setGeneroPelicula(Genero generoPelicula) {
		this.generoPelicula = generoPelicula;
	}

    
}
