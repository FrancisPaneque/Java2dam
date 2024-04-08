package hlc.ud03.examen.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;


public class Validador {
	
  //Lista para almacenar los nombres de los métodos que devuelven false
  public static List<String> errores = new ArrayList<>();
	
  /**
   * Valida si la referencia del producto cumple con los criterios especificados.
   *
   * @param referencia Número de referencia del producto.
   * @return true si la referencia es válida, false en caso contrario.
   */
  public static boolean validarReferencia(String referencia) {
    String regex = "^(3[4-9]|4[0-9]|5[0-9]|6[0-7])\\d{11}$";
    boolean resultado = referencia.matches(regex);
    if (!resultado) {
      agregarError("validar Referencia");
    }
    return resultado;
  }

  /**
   * Valida si el nombre del producto cumple con los criterios especificados.
   *
   * @param nombre Nombre del producto.
   * @return true si el nombre es válido, false en caso contrario.
   */
  public static boolean validarNombre(String nombre) {
    // Nombre del producto debe tener longitud máxima de 200 caracteres
    boolean resultado = nombre.length() <= 200;
    if (!resultado) {
      agregarError("validar Nombre");
    }
    return resultado;
  }

  /**
   * Valida si el precio del producto cumple con los criterios especificados.
   *
   * @param precio Precio del producto.
   * @return true si el precio es válido, false en caso contrario.
   */
  public static boolean validarPrecio(double precio) {
    // Precio debe ser un número real con dos decimales y no puede ser negativo ni cero
    boolean resultado = precio > 0;
    if (!resultado) {
      agregarError("validar Precio");
    }
    return resultado;
  }

  /**
   * Valida si la marca del producto cumple con los criterios especificados.
   *
   * @param marca Marca del producto.
   * @return true si la marca es válida, false en caso contrario.
   */
  public static boolean validarMarca(String marca) {
    // Longitud de la marca debe ser hasta 100 caracteres si se especifica
    boolean resultado = marca == null || marca.length() <= 100;
    if (!resultado) {
      agregarError("validar Marca");
    }
    return resultado;
  }

  /**
   * Valida si la puntuación del producto cumple con los criterios especificados.
   *
   * @param puntuacion Puntuación media dada por los usuarios.
   * @return true si la puntuación es válida, false en caso contrario.
   */
  public static boolean validarPuntuacion(double puntuacion) {
    // Puntuación debe ser un número real con un decimal entre 0 y 5 (ambos incluidos)
    boolean resultado = puntuacion >= 0 && puntuacion <= 5;
    if (!resultado) {
      agregarError("validar Puntuacion");
    }
    return resultado;
  }

  /**
   * Valida si la fecha de inicio de venta cumple con los criterios especificados.
   *
   * @param fecha Fecha en que se puso el producto a la venta en formato dd/mm/aaaa.
   * @return true si la fecha es válida, false en caso contrario.
   */
  public static boolean validarFecha(String fecha) {
    // Fecha en formato dd/mm/aaaa
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    dateFormat.setLenient(false);
    try {
      Date parsedDate = dateFormat.parse(fecha);
      return true;
    } catch (ParseException e) {
      agregarError("validar Fecha");
      return false;
    }
  }

  /**
   * Valida si el nombre de dominio del fabricante cumple con los criterios especificados.
   *
   * @param dominio Nombre de dominio del fabricante.
   * @return true si el dominio es válido, false en caso contrario.
   */
  public static boolean validarDominio(String dominio) {
    // Expresión regular para validar el nombre de dominio
    String patron = "^[a-zA-Z](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    Pattern pattern = Pattern.compile(patron);
    Matcher matcher = pattern.matcher(dominio);
    boolean resultado = matcher.matches();
    if (!resultado) {
      agregarError("validar Dominio");
    }
    return resultado;
  }

  /**
   * Valida si la URL del producto cumple con los criterios especificados.
   *
   * @param url URL a la página del producto en la web.
   * @return true si la URL es válida, false en caso contrario.
   */
  public static boolean validarURL(String url) {
    // Expresión regular para validar una URL
    String patron = "^(https?|ftp)://[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,})+(?:/[^\\s]*)?$";
    Pattern pattern = Pattern.compile(patron);
    Matcher matcher = pattern.matcher(url);
    boolean resultado = matcher.matches();
    if (!resultado) {
      agregarError("validar URL");
    }
    return resultado;
  }

  /**
   * Valida si la dirección de correo para los pedidos cumple con los criterios especificados.
   *
   * @param correoPedidos Dirección de correo para los pedidos.
   * @return true si el correo es válido, false en caso contrario.
   */
  public static boolean validarCorreo(String correoPedidos) {
    // Validación de dirección de correo
    String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
    boolean resultado = correoPedidos.matches(regex);
    if (!resultado) {
      agregarError("validar Correo");
    }
    return resultado;
  }

  /**
   * Valida si los puntos fuertes o débiles del producto cumplen con los criterios especificados.
   *
   * @param puntos Puntos fuertes o débiles del producto.
   * @return true si los puntos son válidos, false en caso contrario.
   */
  public static boolean validarPuntos(String puntos) {
    // Validación de puntos fuertes o débiles
    String regex = "^(Precio|Tecnologia|Durabilidad|Disponibilidad|Marca|Sostenible|Calidad|Tamaño)(,(Precio|Tecnologia|Durabilidad|Disponibilidad|Marca|Sostenible|Calidad|Tamaño)){0,4}$";
    boolean resultado = puntos.matches(regex);
    if (!resultado) {
      agregarError("validar Puntos");
    }
    return resultado;
  }
  
  /**
   * Añade este método para agregar errores a la lista
   * 
   * @param metodo nombre del metodo en el que se esta produciendo el error.
   */
  private static void agregarError(String metodo) {
    errores.add(metodo);
  }
  /**
   * Imprime el numero de errores que contiene el fichero y donde se encuentran
   */
  public static void muestraErrores() {
  	//Imprime el numero de errores
  	System.out.println("Se encontraron los siguientes " + errores.size() + " errores:");
  	//Imrprime donde se han producido los errores
  	for (String error : errores) {
			System.out.println("Error al " + error);
		}
  }
}
