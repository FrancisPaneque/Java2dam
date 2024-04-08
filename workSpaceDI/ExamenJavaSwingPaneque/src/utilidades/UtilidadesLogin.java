package utilidades;

import java.util.HashMap;
import java.util.Map;

import models.Usuario;

public class UtilidadesLogin {
	
	//Mapa que contiene los clientes dados de alta
	public static Map<String, Usuario> usuarios = new HashMap<>();
	
	/**
	 * crea un cliente con los datos tomados en registro
	 * @param nombre
	 * @param apellidos
	 * @param fechaNacimiento
	 * @param email
	 * @param contrasenia
	 * @param perfil
	 * @return
	 */
	public static Usuario creaUsuario(String nombre, String apellidos, String fechaNacimiento, String email, String contrasenia,String perfil) {
		Usuario nuevoUsuario = new Usuario(nombre, apellidos, fechaNacimiento, email, contrasenia, perfil);
		return nuevoUsuario;
	}
	
	
	/**
	 * Metodo que añade un nuevo cliente al mapa
	 * @param nuevoUsuario
	 */
	public static void añadeUsuario(Usuario nuevoUsuario) {
		usuarios.put(nuevoUsuario.getEmail(), nuevoUsuario);
	}
	
}
