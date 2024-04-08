package AADD.tarea4.transacciones;

import java.io.IOException;

public class App {
	private static final String RUTA_FICHERO = "Ficheros/Alumnado_nuevo.txt";
    public static void main( String[] args ) {
        
    	try {
    		Utilidades.crearTablaSuperusuarios();
			Utilidades.leerArchivoLineaPorLinea(RUTA_FICHERO);
			Utilidades.insertUsuarios();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
