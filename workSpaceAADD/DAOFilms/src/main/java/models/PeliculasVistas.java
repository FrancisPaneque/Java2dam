package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PeliculasVistas")
public class PeliculasVistas implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vista")
    private int idVista;

    @Column(name = "id_usuario")
    private int idUsuario;

    @Column(name = "id_pelicula")
    private int idPelicula;

    // Otros campos según sea necesario

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "ID", insertable = false, updatable = false)
    private Pelicula pelicula;

    // Getters & setters

	public int getIdVista() {
		return idVista;
	}

	public void setIdVista(int idVista) {
		this.idVista = idVista;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

    
}
