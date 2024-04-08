package AADD.tarea4.transacciones;

import java.io.IOException;

public class App {
	private static final String RUTA_FICHERO = "Ficheros/prueba.txt";
    public static void main( String[] args ) {
        
    	//lee el archivo y crea Objetos en función del tipo que sea
    	try {
			Utilidades.leerArchivoLineaPorLinea(RUTA_FICHERO);
			for(int i = 0; i >= Utilidades.numeroLineasProcesadas; i++) {
				int numeroProfesor = 0;
				int numeroAsignatura = 0;
				if (Utilidades.indicaTipo(RUTA_FICHERO).equals("Profesor")) {
					Utilidades.insertProfesor(Utilidades.profesores.get(numeroProfesor));
					numeroProfesor+=1;
				} else if (Utilidades.indicaTipo(RUTA_FICHERO).equals("Asignatura")) {
					Utilidades.insertAsignatura(Utilidades.asignaturas.get(numeroAsignatura), Utilidades.profesores.get(numeroProfesor));
					numeroAsignatura+=1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
