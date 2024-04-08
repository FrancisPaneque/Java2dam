package models;

public class Comida {
	
	private String nombreComida;
	private int precio;
	private String ingredientes;
	
	public Comida(String nombreComida, int precio, String ingredientes) {
		super();
		this.nombreComida = nombreComida;
		this.precio = precio;
		this.ingredientes = ingredientes;
	}

	public String getNombreComida() {
		return nombreComida;
	}

	public void setNombreComida(String nombreComida) {
		this.nombreComida = nombreComida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
}
