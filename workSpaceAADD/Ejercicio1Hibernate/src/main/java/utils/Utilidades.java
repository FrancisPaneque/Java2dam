package utils;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import models.SuperUsuario;

public class Utilidades {
	
	/**
	 * Lee el fichero y a añade los datos tomados a lista
	 * @param archivo ruta del fichero
	 * @return lista con los datos del fichero
	 * @throws IOException
	 */
	public static List<String> leerFicheros(String archivo) throws IOException {
	  List<String> lista = new ArrayList<String>();
		
	  try {
	  // Lee el archivo.
      BufferedReader lector = new BufferedReader(new FileReader(archivo));

      // Lee las líneas del fichero y los añado a la lista.
      String linea = lector.readLine();
      
      while (linea != null) {
          lista.add(linea);
          linea = lector.readLine();
      }
      
      lector.close();
	  
	  }catch (Exception e) {
      
		  System.out.println("El fichero no existe");
	  
	  }   

		return lista;
	}
	
	/**
	 * Crea una cadena con los atributos de SuperUsuario
	 * @param usuarioString
	 * @return SuperUsuario
	 */
	private static String creaSuperUsuario(String[] usuarioString) {
		String user = "2DAM";
		String nombre = "" + usuarioString[1].charAt(0) + usuarioString[1].charAt(1);
		String apellido = "" + usuarioString[0].charAt(0) + usuarioString[0].charAt(1);
		return user + nombre + apellido;
	}	
	
	/**
	 * Con los datos de la lista, crea a un objeto de la clase SuperUsuario y los guarda en una lista
	 * @param archivo ruta del fichero
	 * @return listaSuperUsuario lista que contiene SuperUsuarios
	 * @throws IOException
	 */
	public static List<SuperUsuario> creaSuperUsuarios(String archivo) throws IOException {
		List<SuperUsuario> listaSuperUsuario = new ArrayList<SuperUsuario>();
		// guarda los datos leidos del fichero
		List<String> datos = leerFicheros(archivo);
		
		// recorre la lista de datos
		for (int i = 0; i < datos.size(); i++) {
			String usuarioString[] = datos.get(i).split(", "); 
			
			SuperUsuario usuario = new SuperUsuario();
			usuario.setNombre(usuarioString[1]);
			usuario.setApellidos(usuarioString[0]);
			usuario.setUser(creaSuperUsuario(usuarioString));
			
			listaSuperUsuario.add(usuario);
		}
		return listaSuperUsuario;
	}
}
