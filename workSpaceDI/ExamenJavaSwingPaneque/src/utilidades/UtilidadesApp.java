package utilidades;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.*;

public class UtilidadesApp {
	
	//Lista de usuarios
	public static List<Usuario> listaDeUsuarios = new ArrayList<>(UtilidadesLogin.usuarios.values());
	//Mapa que contiene las clases
	public static Map<String, Clase> clases = new HashMap<>();
	//Lista que contiene las clases
	public static List<Clase> listaDeClases = new ArrayList<>(clases.values());
	
	/**
	 * Retorna un usuario
	 * @param i
	 * @return
	 */
	public static Usuario devuelveCliente(int i) {
		Usuario usuario = null;
		
		if (listaDeUsuarios.get(i).getPerfil().equals("Cliente")) {
			usuario = listaDeUsuarios.get(i);
		}
		return usuario;
	}
	
	/**
	 * Crea ua nueva clase
	 * @param nombre
	 * @param profesor
	 * @param turno
	 * @return
	 */
	public static Clase creaClase(String nombre, String profesor, String turno) {
		Clase nuevoClase = new Clase(nombre, profesor, turno);
		return nuevoClase;
	}
	
	
	/**
	 * Metodo que añade una nueva clase al mapa
	 * @param nuevoUsuario
	 */
	public static void añadeClase(Clase nuevoClase) {
		clases.put(nuevoClase.getNombre(), nuevoClase);
	}
	
	public static String imprimirFechaActual() {
        Date fechaActual = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = dateFormat.format(fechaActual);
        return fechaFormateada;
    }
	
	/**
	 * Busca en la lista de los cliente que sea igual al email que se le pasa por parametro
	 * @param email
	 * @return cliente
	 */
	
	public static int buscaCliente(String email) {
		int cliente = 0;
		
		for(int i = 0; i < listaDeUsuarios.size(); i++) {
			
			String correo = listaDeUsuarios.get(i).getEmail();
			if (correo.equalsIgnoreCase(email)) {
				
				cliente = i;
			}
		}
		return cliente;
	}
	
}
