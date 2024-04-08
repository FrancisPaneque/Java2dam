package hlc.ud02.examen.utilidades;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;



public class Utilidades {

	// Constantes para el algoritmo de resumen, el archivo de keystore, y entrada
	private static final String ALGORITMO = "SHA-256";
	private static final String ARCHIVO_KEYSTORE = "claves.keystore";
	private static final String ENTRADA = "default";
	
	//Variable estática para almacenar la clave
	private static Key clave = null;
	
	/**
   * Método para verificar la cantidad de parámetros pasados al programa.
   * @param args Los argumentos pasados al programa.
   * @return true si se pasaron al menos dos parámetros, false en caso contrario.
   */
  public static boolean verificarParametros(String[] args) {
      return args != null && args.length >= 2;
  }
  
  /**
   * Método para verificar la cantidad de parámetros pasados al programa.
   * @param args Los argumentos pasados al programa.
   * @return true si se pasaron al menos dos parámetros, false en caso contrario.
   */
  public static boolean verificarParametrosMayorQue2(String[] args) {
      return args != null && args.length > 2;
  }
	
	/**
	 * Metodo que realiza el resumen de los bytes del archivo pasado
	 * @param archivo ruta del archivo
	 * @return byte[] archioResumido
	 */
	public static byte[] resumeArchivo(String archivo) {
		//Array que contiene el archivo resumido
		byte[] archivoResumido = null;
		FileInputStream reader = null;
		
		try {
			
			// Inicializa el resumidor con el algoritmo especificado
			MessageDigest resumidor = MessageDigest.getInstance(ALGORITMO);
			
			// Lee el archivo y actualiza el resumidor con los bytes leídos
			reader = new FileInputStream(archivo);
			byte[] buffer = new byte[8192];
			int bytesLeidos;
			
			while ((bytesLeidos = reader.read(buffer)) != -1) {
				resumidor.update(buffer, 0, bytesLeidos);
			}
			
			// Obtiene el resumen final
			archivoResumido = resumidor.digest();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cierre del lector en el bloque finally
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return archivoResumido;
	}
	
	/**
	 * Metodo que inicalaiza la clave privada
	 * @param password parametro de contraseña
	 */
	public static void inicializaClave(String password) {
		
		FileInputStream reader = null;
		
		// Verifica si la clave ya ha sido inicializada
		if (clave == null) {	
			try {
				// Lee el keystore desde el archivo y obtiene la clave privada
				reader = new FileInputStream(ARCHIVO_KEYSTORE);
				KeyStore store = KeyStore.getInstance(KeyStore.getDefaultType());
				store.load(reader, password.toCharArray());
				clave = store.getKey(ENTRADA, password.toCharArray());
			} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
				System.err.println("Contraseña invalida, la contraseña introducida no es la correcta");
				e.printStackTrace();
			}	finally {
        // Cierre del lector en el bloque finally
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
		}
	}
	
  /**
   * método convierte un array de bytes a una cadena en formato Base64
   * @param cifrado Array de bytes que contiene el resumen cifrado
   * @return encriptadoBase64
   */
	public static String pasaBase64(byte[] cifrado) {
		String encriptadoBase64 = Base64.getEncoder().encodeToString(cifrado);
		return encriptadoBase64;
	}
	
  /**
   * Este método encripta el resumen utilizando una clave privada y lo devuelve en base64
   * @param password clave privada obtenida del fichero de claves
   * @param resumen archivo resumido
   * @return cifrado archivo resumido, cifrado y pasado a base64
   */
	public static String encripta(String password, byte[] resumen) {
		// Inicializa la clave privada
		inicializaClave(password);
		byte[] cifrado = null;
		try {
			// Obtiene una instancia del algoritmo de cifrado RSA
			Cipher algoritmo = Cipher.getInstance("RSA");
			// Inicializa el algoritmo en modo de cifrado con la clave privada
			algoritmo.init(Cipher.ENCRYPT_MODE, clave);
			// Realiza el cifrado y devuelve el resultado en formato Base64
			cifrado = algoritmo.doFinal(resumen);
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return pasaBase64(cifrado);
	}
}
