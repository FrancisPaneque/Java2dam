package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pelicula_Compañia")
public class PeliculaCompañia implements java.io.Serializable {

    @Id
    @Column(name = "id_pelicula")
    private int idPelicula;

    @Id
    @Column(name = "nombre_compañia")
    private String nombreCompañia;

    // Otros campos según sea necesario

    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "ID", insertable = false, updatable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "nombre_compañia", referencedColumnName = "nombre_compañia", insertable = false, updatable = false)
    private Compañia compañia;
    
    // Getters & setters

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombreCompañia() {
		return nombreCompañia;
	}

	public void setNombreCompañia(String nombreCompañia) {
		this.nombreCompañia = nombreCompañia;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Compañia getCompañia() {
		return compañia;
	}

	public void setCompañia(Compañia compañia) {
		this.compañia = compañia;
	}

}