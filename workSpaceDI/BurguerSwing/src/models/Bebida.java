package models;

public class Bebida {
	
	private String nombreBebida;
	private int precio;
	
	public Bebida(String nombreBebida, int precio) {
		super();
		this.nombreBebida = nombreBebida;
		this.precio = precio;
	}

	public String getNombreBebida() {
		return nombreBebida;
	}

	public void setNombreBebida(String nombreBebida) {
		this.nombreBebida = nombreBebida;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}
