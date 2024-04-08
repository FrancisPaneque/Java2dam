package hlc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utiles {
	
	
	/**
	 * Metodo encargado de validar que cada parte del codigo sea correcta
	 * @param campos array que contiene cada linea de fichero
	 */
	public static void validarCampos(String[] campos) {
    validarTitulo(campos[0]);
    validarNombre(campos[1]);
    validarApellidos(campos[2]);
    validarTelefono(campos[3]);
    validarCP(campos[4]);
    validarEmail(campos[5]);
    validarURL(campos[6]);
    validarUsername(campos[7]);
    validarPassword(campos[8]);
    validarFechaRegistro(campos[9]);
	}
	
	/**
   * Valida el campo 'Titulo'.
   *
   * @param titulo Valor del campo 'Titulo'.
   * @throws IllegalArgumentException Si el título no es válido.
   */
  private static void validarTitulo(String titulo) {
      if (!titulo.equals("Doctor") && !titulo.equals("Señor") && !titulo.equals("Señora")) {
          throw new IllegalArgumentException("Campo 'Titulo' incorrecto.");
      }
  }

  /**
   * Valida el campo 'Nombre'.
   *
   * @param nombre Valor del campo 'Nombre'.
   * @throws IllegalArgumentException Si el nombre es demasiado largo.
   */
  private static void validarNombre(String nombre) {
      if (nombre.length() > 50) {
          throw new IllegalArgumentException("Campo 'Nombre' demasiado largo.");
      }
  }

  /**
   * Valida el campo 'Apellidos'.
   *
   * @param apellidos Valor del campo 'Apellidos'.
   * @throws IllegalArgumentException Si los apellidos son demasiado largos.
   */
  private static void validarApellidos(String apellidos) {
      if (apellidos.length() > 100) {
          throw new IllegalArgumentException("Campo 'Apellidos' demasiado largo.");
      }
  }

  /**
   * Valida el campo 'Telefono'.
   *
   * @param telefono Valor del campo 'Telefono'.
   * @throws IllegalArgumentException Si el teléfono no es válido.
   */
  private static void validarTelefono(String telefono) {
      if (!telefono.matches("[6-9]\\d{8}")) {
          throw new IllegalArgumentException("Campo 'Telefono' incorrecto.");
      }
  }

  /**
   * Valida el campo 'CP'.
   *
   * @param cp Valor del campo 'CP'.
   * @throws IllegalArgumentException Si el código postal no es válido.
   */
  private static void validarCP(String cp) {
      if (!cp.matches("[1-5][0-2]\\d{3}")) {
          throw new IllegalArgumentException("Campo 'CP' incorrecto.");
      }
  }

  /**
   * Valida el campo 'Email'.
   *
   * @param email Valor del campo 'Email'.
   * @throws IllegalArgumentException Si el correo electrónico no es válido.
   */
  private static void validarEmail(String email) {
      if (!email.matches(".+@.+\\..+")) {
          throw new IllegalArgumentException("Campo 'Email' incorrecto.");
      }
  }

  /**
   * Valida el campo 'URL'.
   *
   * @param url Valor del campo 'URL'.
   * @throws IllegalArgumentException Si la URL no es válida.
   */
  private static void validarURL(String url) {
      if (!url.isEmpty() && !url.matches("http(s)?://.+")) {
          throw new IllegalArgumentException("Campo 'URL' incorrecto.");
      }
  }

  /**
   * Valida el campo 'Username'.
   *
   * @param username Valor del campo 'Username'.
   * @throws IllegalArgumentException Si el nombre de usuario no es válido.
   */
  private static void validarUsername(String username) {
      if (!username.matches("[a-zA-Z0-9_\\-]{1,10}")) {
          throw new IllegalArgumentException("Campo 'Username' incorrecto.");
      }
  }

  /**
   * Valida el campo 'Password'.
   *
   * @param password Valor del campo 'Password'.
   * @throws IllegalArgumentException Si la contraseña no es válida.
   */
  private static void validarPassword(String password) {
      if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[.*;,:/*&%$()]).{8,16}$")) {
          throw new IllegalArgumentException("Campo 'Password' incorrecto.");
      }
  }

  /**
   * Valida el campo 'Fecha-Registro'.
   *
   * @param fechaRegistro Valor del campo 'Fecha-Registro'.
   * @throws IllegalArgumentException Si la fecha de registro no es válida.
   */
  private static void validarFechaRegistro(String fechaRegistro) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      sdf.setLenient(false);

      try {
          Date date = sdf.parse(fechaRegistro);
      } catch (ParseException e) {
          throw new IllegalArgumentException("Campo 'Fecha-Registro' incorrecto.");
      }
  }
	
}
