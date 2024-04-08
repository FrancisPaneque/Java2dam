package productos;

/**
 * Clase que representa a los productos.
 */
public class Productos {
    private static final long serialVersionUID = 1L;
    private Integer id; // Identificador del producto
    private String producto; // Nombre del producto
    private Integer proveedorId; // ID del proveedor asociado al producto
    private Integer categoriaId; // ID de la categoría a la que pertenece el producto
    private String cantidadPorUnidad; // Cantidad por unidad del producto
    private Double precioUnidad; // Precio por unidad del producto
    private Integer unidadesExistencia; // Unidades en existencia del producto
    private Integer unidadesPedido; // Unidades en pedido del producto
    private Integer nivelNuevoPedido; // Nivel de nuevo pedido del producto
    private Integer suspendido; // Estado de suspensión del producto

    /**
     * Constructor por defecto de la clase Productos.
     */
    public Productos() {
    }

    // Getters y Setters

    /**
     * Obtiene el ID del producto.
     * @return El ID del producto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     * @param id El ID del producto a establecer.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Establece el nombre del producto.
     * @param producto El nombre del producto a establecer.
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Obtiene el ID del proveedor asociado al producto.
     * @return El ID del proveedor asociado al producto.
     */
    public Integer getProveedorId() {
        return proveedorId;
    }

    /**
     * Establece el ID del proveedor asociado al producto.
     * @param proveedorId El ID del proveedor asociado al producto a establecer.
     */
    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    /**
     * Obtiene el ID de la categoría a la que pertenece el producto.
     * @return El ID de la categoría a la que pertenece el producto.
     */
    public Integer getCategoriaId() {
        return categoriaId;
    }

    /**
     * Establece el ID de la categoría a la que pertenece el producto.
     * @param categoriaId El ID de la categoría a la que pertenece el producto a establecer.
     */
    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    /**
     * Obtiene la cantidad por unidad del producto.
     * @return La cantidad por unidad del producto.
     */
    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    /**
     * Establece la cantidad por unidad del producto.
     * @param cantidadPorUnidad La cantidad por unidad del producto a establecer.
     */
    public void setCantidadPorUnidad(String cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }

    /**
     * Obtiene el precio por unidad del producto.
     * @return El precio por unidad del producto.
     */
    public Double getPrecioUnidad() {
        return precioUnidad;
    }

    /**
     * Establece el precio por unidad del producto.
     * @param precioUnidad El precio por unidad del producto a establecer.
     */
    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    /**
     * Obtiene las unidades en existencia del producto.
     * @return Las unidades en existencia del producto.
     */
    public Integer getUnidadesExistencia() {
        return unidadesExistencia;
    }

    /**
     * Establece las unidades en existencia del producto.
     * @param unidadesExistencia Las unidades en existencia del producto a establecer.
     */
    public void setUnidadesExistencia(Integer unidadesExistencia) {
        this.unidadesExistencia = unidadesExistencia;
    }

    /**
     * Obtiene las unidades en pedido del producto.
     * @return Las unidades en pedido del producto.
     */
    public Integer getUnidadesPedido() {
        return unidadesPedido;
    }

    /**
     * Establece las unidades en pedido del producto.
     * @param unidadesPedido Las unidades en pedido del producto a establecer.
     */
    public void setUnidadesPedido(Integer unidadesPedido) {
        this.unidadesPedido = unidadesPedido;
    }

    /**
     * Obtiene el nivel de nuevo pedido del producto.
     * @return El nivel de nuevo pedido del producto.
     */
    public Integer getNivelNuevoPedido() {
        return nivelNuevoPedido;
    }

    /**
     * Establece el nivel de nuevo pedido del producto.
     * @param nivelNuevoPedido El nivel de nuevo pedido del producto a establecer.
     */
    public void setNivelNuevoPedido(Integer nivelNuevoPedido) {
        this.nivelNuevoPedido = nivelNuevoPedido;
    }

    /**
     * Obtiene el estado de suspensión del producto.
     * @return El estado de suspensión del producto.
     */
    public Integer getSuspendido() {
        return suspendido;
    }

    /**
     * Establece el estado de suspensión del producto.
     * @param suspendido El estado de suspensión del producto a establecer.
     */
    public void setSuspendido(Integer suspendido) {
        this.suspendido = suspendido;
    }

    /**
     * Obtiene el serialVersionUID.
     * @return El serialVersionUID.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Sobrescribe el método equals para comparar objetos Productos.
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
        Productos other = (Productos) obj;
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
     * Devuelve una representación en forma de cadena de los valores de los campos del producto, separados por ";".
     * @return La representación en forma de cadena del producto.
     */
    @Override
    public String toString() {
        return this.getId() + ";" + this.getProducto() + ";" + this.getProveedorId() + ";" + this.categoriaId + ";" + this.cantidadPorUnidad + ";" 
                + this.precioUnidad + ";" + this.unidadesExistencia + ";" + this.unidadesPedido + ";" + this.nivelNuevoPedido + ";" + this.suspendido;
    }

    /**
     * Devuelve los nombres de los campos separados por ";".
     * @return Los nombres de los campos separados por ";".
     */
    public static String getCamposToString() {
        return "id;producto;proveedor_id;categoria_id;cantidad_por_unidad;precio_unidad;unidades_existencia;unidades_pedido;nivel_nuevo_pedido;suspendido";
    }
}
	
	