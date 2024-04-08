package hlc.ud03.examen.main;

import hlc.ud03.examen.datos.BloqueDatosEnFichero;
import hlc.ud03.examen.utils.Validador;
import java.io.File;

public class ValidarProductoApp {

	/**
	 * Metodo main encargado de lanzar el programa
	 * @param args
	 */
	public static void main(String[] args) {
    // Verificar que se proporcionó la ruta del archivo como argumento
    if (args.length != 1) {
    	  System.out.println("Erro al introducir parametros");
        System.out.println("Uso: java ValidarProductoApp <ruta_del_archivo>");
        System.exit(1);
    }

    // Obtener la ruta del archivo desde los argumentos
    String rutaArchivo = args[0];
    
    // Validar la existencia del archivo
    if (!validarRutaArchivo(rutaArchivo)) {
        System.out.println("La ruta del archivo no es válida.");
        System.exit(1);
    }
    
    // Procesar el archivo y validar los datos
    BloqueDatosEnFichero bloqueDatosEnFichero = new BloqueDatosEnFichero(rutaArchivo);

    // Validar los datos utilizando los métodos de ValidacionesProducto
    if (validarDatos(bloqueDatosEnFichero)) {
        System.out.println("No se encontraron errores.");
    } else {
        System.out.println("Los datos del archivo no son válidos.");
        // Muestra en que validación se han producido los errores
        Validador.muestraErrores();
    }
}

private static boolean validarDatos(BloqueDatosEnFichero bloqueDatosEnFichero) {
  
	//Campos que su aparicion pueden ser opcional
	//Comprueba si el archivo contiene estos campos
	boolean puntosFuertesOpcionales = true;
  if (bloqueDatosEnFichero.contieneDato("puntos_fuertes")) {
      puntosFuertesOpcionales = Validador.validarPuntos(bloqueDatosEnFichero.getDato("puntos_fuertes"));
  }

  boolean puntosDebilesOpcionales = true;
  if (bloqueDatosEnFichero.contieneDato("puntos_debiles")) {
      puntosDebilesOpcionales = Validador.validarPuntos(bloqueDatosEnFichero.getDato("puntos_debiles"));
  }
  
  boolean marcaOpcional = true;
  if (bloqueDatosEnFichero.contieneDato("marca")) {
      marcaOpcional = Validador.validarMarca(bloqueDatosEnFichero.getDato("marca"));
  }
	
  // Utilizar los métodos de ValidacionesProducto para validar cada campo
  return Validador.validarReferencia(bloqueDatosEnFichero.getDato("referencia"))
            && Validador.validarNombre(bloqueDatosEnFichero.getDato("nombre"))
            && Validador.validarPrecio(Double.parseDouble(bloqueDatosEnFichero.getDato("precio")))
            && Validador.validarPuntuacion(Double.parseDouble(bloqueDatosEnFichero.getDato("puntuacion")))
            && Validador.validarFecha(bloqueDatosEnFichero.getDato("fecha_inicio_venta"))
            && Validador.validarDominio(bloqueDatosEnFichero.getDato("dominio"))
            && Validador.validarURL(bloqueDatosEnFichero.getDato("url"))
            && Validador.validarCorreo(bloqueDatosEnFichero.getDato("correo_pedidos"))
            && puntosFuertesOpcionales
            && puntosDebilesOpcionales
            && marcaOpcional;
}

/**
 * Valida si la ruta del archivo existe o no
 * 
 * @param rutaArchivo
 * @return
 */
private static boolean validarRutaArchivo(String rutaArchivo) {
  // Utilizar la clase File para verificar la existencia del archivo
  File archivo = new File(rutaArchivo);
  return archivo.exists() && archivo.isFile();
}

}