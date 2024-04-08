package proveedor;

/**
 * Clase que representa a los proveedores.
 */
public class Proveedores {
    private static final long serialVersionUID = 1L;
    private Integer id; // Identificador del proveedor
    private String empresa; // Nombre de la empresa del proveedor
    private String contacto; // Información de contacto del proveedor

    /**
     * Constructor por defecto de la clase Proveedores.
     */
    public Proveedores() {
    }

    /**
     * Obtiene el ID del proveedor.
     * @return El ID del proveedor.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del proveedor.
     * @param id El ID del proveedor a establecer.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de la empresa del proveedor.
     * @return El nombre de la empresa del proveedor.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Establece el nombre de la empresa del proveedor.
     * @param empresa El nombre de la empresa del proveedor a establecer.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Obtiene la información de contacto del proveedor.
     * @return La información de contacto del proveedor.
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Establece la información de contacto del proveedor.
     * @param contacto La información de contacto del proveedor a establecer.
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * Obtiene el serialVersionUID.
     * @return El serialVersionUID.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Sobrescribe el método equals para comparar objetos Proveedores.
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
        Proveedores other = (Proveedores) obj;
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
     * Devuelve una representación en forma de cadena de los valores de los campos del proveedor, separados por ";".
     * @return La representación en forma de cadena del proveedor.
     */
    @Override
    public String toString() {
        return this.getId() + ";" + this.getEmpresa() + ";" + this.getContacto();
    }

    /**
     * Devuelve los nombres de los campos separados por ";".
     * @return Los nombres de los campos separados por ";".
     */
    public static String getCamposToString() {
        return "id;empresa;contacto";
    }
}