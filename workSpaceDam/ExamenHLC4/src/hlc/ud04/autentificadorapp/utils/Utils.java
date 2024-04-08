package hlc.ud04.autentificadorapp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Clase de utilidades que proporciona métodos para generar números aleatorios,
 * cifrar contraseñas usando el cifrado César y buscar valores en archivos de
 * propiedades.
 */
public class Utils {

  /**
   * Genera un número aleatorio entre 1 y 23 (ambos inclusive).
   * @return Número aleatorio generado.
   */
  public static int generaRandomNumber() {
    // Generamos un número aleatorio entre 1 y 23 (ambos inclusive)
    int randomNumber = (int) (Math.random() * 23) + 1;

    return randomNumber;
  }

  /**
   * Cifra una contraseña utilizando el cifrado César.
   * @param passwordSinCifrar Contraseña sin cifrar.
   * @param numeroCifraCesar Número para el cifrado César.
   * @return Contraseña cifrada.
   */
  public static String cifraCesarPassword(String passwordSinCifrar, int numeroCifraCesar) {
    StringBuilder cifrado = new StringBuilder();

    for (int i = 0; i < passwordSinCifrar.length(); i++) {
      char caracter = passwordSinCifrar.charAt(i);

      if (Character.isLetter(caracter)) {
        char base = Character.isLowerCase(caracter) ? 'a' : 'A';
        cifrado.append((char) ((caracter - base + numeroCifraCesar) % 26 + base));
      } else {
        cifrado.append(caracter);
      }
    }

    return cifrado.toString();
  }

  /**
   * Busca un valor en un archivo de propiedades.
   * @param archivo Nombre del archivo de propiedades.
   * @param clave Clave para buscar el valor.
   * @return Valor asociado a la clave en el archivo de propiedades, o null si no se encuentra.
   */
  public static String buscarValor(String archivo, String clave) {
    Properties prop = new Properties();
    try {
      prop.load(new FileInputStream(archivo));
      return prop.getProperty(clave);
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}
