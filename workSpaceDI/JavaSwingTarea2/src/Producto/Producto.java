package Producto;

public class Producto {
	
	private String nombreProducto;
	private double precio;
	private boolean precedero;
	
	public Producto(String nombreProducto, double precio, boolean precedero) {
		setNombreProducto(nombreProducto);
		setPrecio(precio);
		setPrecedero(precedero);
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean getPrecedero() {
		return precedero;
	}

	public void setPrecedero(boolean b) {
		this.precedero = b;
	}

	@Override
	public String toString() {
		return "Producto [nombreProducto=" + nombreProducto + ", precio=" + precio + ", precedero=" + precedero + "]" + "\n";
	}
	
	
}
