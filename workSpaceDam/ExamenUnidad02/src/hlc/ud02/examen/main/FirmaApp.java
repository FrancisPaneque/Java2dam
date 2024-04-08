package hlc.ud02.examen.main;

import hlc.ud02.examen.utilidades.*;
public class FirmaApp {
	
	//Declaración de variables estáticas
	private static String archivo;
	private static String password;
	private static byte[] archivoResumido;
	private static String firma;
	
	/**
	 * Main de app encargado de realizar el resumen, encriptamiento e impresión de un archivo
	 * @param args parametros pasados por consola en especifico ruta del archivo y password
	 */
	public static void main(String[] args) {
		
    // Verifica si se han proporcionado la cantidad correcta de parámetros
		if(!Utilidades.verificarParametros(args)) {
			System.err.println("Número de parametros inconrrecto introduzca, introduzca dos parametros");
			return;
		}  else if (Utilidades.verificarParametrosMayorQue2(args)){
			// Si se proporcionan mas dos parámetros, asigna la ruta del archivo y la contraseña, pero solo toma los dos primeros parametros
			System.out.println("Solo se han tomado los dos primeros parametros");
			System.out.println("Número de parametros correcto, continuamos...");
			archivo = args[0];
			password = args[1];
		} else {
		// Si se proporcionan mas dos parámetros, asigna la ruta del archivo y la contraseña
			System.out.println("Número de parametros correcto, continuamos...");
			archivo = args[0];
			password = args[1];
		}
		// Obtiene el resumen del archivo
		archivoResumido = Utilidades.resumeArchivo(archivo);
		// Encripta el resumen y lo imprime
		firma = Utilidades.encripta(password, archivoResumido);
		System.out.println("El resumen encriptado del archivo pasado es:");
		System.out.println(firma);
	}

}
