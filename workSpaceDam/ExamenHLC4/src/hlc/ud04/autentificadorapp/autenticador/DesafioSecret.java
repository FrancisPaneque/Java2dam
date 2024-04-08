package hlc.ud04.autentificadorapp.autenticador;

import hlc.ud04.appsec.seguridad.autenticacion.Desafio;

/**
 * Clase que representa un desafío secreto para el proceso de autenticación.
 */
public class DesafioSecret implements Desafio {

  private String usuario;

  /**
   * Constructor de la clase DesafioSecret.
   * @param usuario Nombre de usuario asociado al desafío secreto.
   */
  public DesafioSecret(String usuario) {
    this.usuario = usuario;
  }

  /**
   * Obtiene el nombre de usuario asociado al desafío.
   * @return Nombre de usuario.
   */
  public String getUsuario() {
    return usuario;
  }
}