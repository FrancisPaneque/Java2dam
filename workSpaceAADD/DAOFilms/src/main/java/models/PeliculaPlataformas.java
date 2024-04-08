package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pelicula_Plataformas")
public class PeliculaPlataformas implements java.io.Serializable {

    @Id
    @Column(name = "id_pelicula")
    private int idPelicula;

    @Id
    @Column(name = "localizacion")
    private String localizacion;

    // Otros campos según sea necesario

    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "ID", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "localizacion", referencedColumnName = "localizacion", insertable = false, updatable = false)
    private Plataformas plataforma;
    
    // Getters & setters

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Plataformas getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(Plataformas plataforma) {
		this.plataforma = plataforma;
	}

}