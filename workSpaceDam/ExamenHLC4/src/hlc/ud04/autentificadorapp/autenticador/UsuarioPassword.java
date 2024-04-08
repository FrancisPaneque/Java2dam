package hlc.ud04.autentificadorapp.autenticador;

/**
 * Clase que representa un usuario con su nombre, contraseña y identificador único.
 */
public class UsuarioPassword {

  private String nombre;
  private String password;
  private int id;

  /**
   * Constructor de la clase UsuarioPassword.
   * @param nombre Nombre del usuario.
   * @param password Contraseña del usuario.
   * @param id Identificador único del usuario.
   */
  public UsuarioPassword(String nombre, String password, int id) {
    this.nombre = nombre;
    this.password = password;
    this.id = id;
  }

  /**
   * Obtiene el nombre del usuario.
   * @return Nombre del usuario.
   */
  public String getNombre() {
    return nombre;
  }

  /**
   * Obtiene la contraseña del usuario.
   * @return Contraseña del usuario.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Obtiene el identificador único del usuario.
   * @return Identificador único del usuario.
   */
  public int getId() {
    return id;
  }
}
