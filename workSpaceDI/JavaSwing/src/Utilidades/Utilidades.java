package Utilidades;

import Cliente.Cliente;
import Front.PantaPrincipal;
import Producto.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Utilidades {
	//Mapa que contiene los clientes dados de alta
	public static Map<String, String> clientes = new HashMap<>();
	//Lista que contiene los productos dados de alta
	public static List<Producto> productos = new ArrayList<>();;
	
	/**
	 * Metodo que crea un cliente con los datos dados
	 * @param nombre
	 * @param apellidos
	 * @param edad
	 * @param provincia
	 * @return
	 */
	public static Cliente creaCliente(String nombre, String apellidos, int edad, String provincia) {
		Cliente nuevoCliente = new Cliente(nombre, apellidos, edad, provincia);
		return nuevoCliente;
	}
	/**
	 * Metodo que añade un nuevo cliente al mapa
	 * @param nuevoCliente
	 */
	public static void añadeCliente(Cliente nuevoCliente) {
		clientes.put(nuevoCliente.getNombre(), nuevoCliente.toString());
	}
	/**
	 * reinicia los campos de AltaCliente
	 * @param textNombre
	 * @param textApellidos
	 * @param textEdad
	 */
	public static void reiniciaCliente(JTextField textNombre, JTextField textApellidos, JTextField textEdad) {
		textNombre.setText("");
		textApellidos.setText("");
		textEdad.setText("");
	}
	/**
	 * metodo que imprme a la los clientes dados de alta
	 * @param textArea
	 */
	public static void imprimeClientes(JTextArea textArea) {
		textArea.setText("");
		for (Map.Entry<String, String> entry : clientes.entrySet()) {
            String valor = entry.getValue();
            textArea.append(valor);
            System.out.println(valor);
        }
	}
	/**
	 * elimina al cliente seleccionado del mapa
	 * @param cliente
	 */
	public static void eliminaCliente(String cliente) {
		//elimina del mapa el cliente que se introduce
		clientes.remove(cliente);
	}
	/**
	 * Crea un objeto de la clase producto
	 * @param nombreProducto
	 * @param precio
	 * @param b
	 * @return
	 */
	public static Producto creaProducto(String nombreProducto, double precio, boolean precedero) {
		Producto producto = new Producto(nombreProducto, precio, precedero);
		return producto;
		
	}
	/**
	 * Metodo que añade un nuevo prodcuto a la lista
	 * @param nuevoCliente
	 */
	public static void añadeProducto(Producto nuevoProducto) {
		productos.add(nuevoProducto);
	}
	
	/**
	 * reinicia los campos de AltaCliente
	 * @param textNombre
	 * @param textApellidos
	 * @param textEdad
	 */
	public static void reiniciaProducto(JTextField textProducto, JTextField textPrecio) {
		textProducto.setText("");
		textPrecio.setText("");
		
	}
	/**
	 * metodo que imprme a los productos dados de alta
	 * @param textArea
	 */
	public static void imprimeProductos(JTextArea textArea) {
		textArea.setText("");
		for (Producto elemento : productos) {
			textArea.append(elemento.toString());
        }
	}
}
