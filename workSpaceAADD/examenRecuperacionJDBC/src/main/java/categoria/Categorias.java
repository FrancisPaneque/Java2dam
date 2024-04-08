package categoria;

import java.io.Serializable;

/**
 * Clase que representa a las categorías.
 */
public class Categorias implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id; // Identificador de la categoría
    private String categoria; // Nombre de la categoría
    private String descripcion; // Descripción de la categoría

    /**
     * Obtiene el ID de la categoría.
     * @return El ID de la categoría.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID de la categoría.
     * @param id El ID de la categoría a establecer.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la categoría.
     * @return El nombre de la categoría.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Establece el nombre de la categoría.
     * @param categoria El nombre de la categoría a establecer.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene la descripción de la categoría.
     * @return La descripción de la categoría.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría.
     * @param descripcion La descripción de la categoría a establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el serialVersionUID.
     * @return El serialVersionUID.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Sobrescribe el método equals para comparar objetos Categorias.
     * @param obj El objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Categorias other = (Categorias) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena de los valores de los campos de la categoría, separados por ";".
     * @return La representación en forma de cadena de la categoría.
     */
    @Override
    public String toString() {
        return this.getId() + ";" + this.getCategoria() + ";" + this.getDescripcion();
    }

    /**
     * Devuelve los nombres de los campos separados por ";".
     * @return Los nombres de los campos separados por ";".
     */
    public static String getCamposToString() {
        return "id;categoria;descripcion";
    }
}
