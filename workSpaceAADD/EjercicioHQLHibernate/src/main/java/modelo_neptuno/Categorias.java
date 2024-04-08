package modelo_neptuno;
// Generated 20 ene. 2021 12:08:17 by Hibernate Tools 5.4.21.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Categorias generated by hbm2java
 */
public class Categorias implements java.io.Serializable {

	private Integer id;
	private String categoria;
	private String descripcion;
	private Set productoses = new HashSet(0);

	public Categorias() {
	}

	public Categorias(String categoria) {
		this.categoria = categoria;
	}

	public Categorias(String categoria, String descripcion, Set productoses) {
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.productoses = productoses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getProductoses() {
		return this.productoses;
	}

	public void setProductoses(Set productoses) {
		this.productoses = productoses;
	}

}
