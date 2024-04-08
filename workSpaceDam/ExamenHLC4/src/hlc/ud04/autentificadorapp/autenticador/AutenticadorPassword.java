package hlc.ud04.autentificadorapp.autenticador;

import java.util.Map;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.autentificadorapp.persistencia.GestorPersistenciaSqliteUsuario;
import hlc.ud04.autentificadorapp.seguridad.SistemaSeguridadPassword;
import hlc.ud04.autentificadorapp.utils.Utils;

/**
 * Clase que implementa el interfaz Autenticador y proporciona métodos para iniciar y finalizar
 * el proceso de autenticación de usuarios utilizando contraseñas.
 */
public class AutenticadorPassword implements Autenticador {

  Map<String, UsuarioPassword> usuarios;

  /**
   * Constructor de la clase AutenticadorPassword. Lee los usuarios y contraseñas de la base de
   * datos al inicializar el autenticador.
   */
  public AutenticadorPassword() {
    GestorPersistenciaSqliteUsuario proveedor = new GestorPersistenciaSqliteUsuario("jdbc:sqlite:db/base.db");
    usuarios = proveedor.leeUsuario();
  }

  /**
   * Inicia el proceso de autenticación para un usuario dado.
   * @param usuario Nombre de usuario para el cual se inicia la autenticación.
   * @return Desafío generado para el proceso de autenticación.
   */
  @Override
  public Desafio iniciaAutenticacion(String usuario) {
    return new DesafioSecret(usuario);
  }

  /**
   * Finaliza el proceso de autenticación verificando la respuesta proporcionada por el usuario.
   * @param desafio Desafío utilizado durante el proceso de autenticación.
   * @param respuesta Respuesta proporcionada por el usuario al desafío.
   * @return Usuario autenticado si la respuesta es correcta, de lo contrario devuelve null.
   */
  @Override
  public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
    DesafioSecret desafioPassword = (DesafioSecret) desafio;
    RespuestaDesafioPassword respuestaPassword = (RespuestaDesafioPassword) respuesta;
    if (usuarios.containsKey(desafioPassword.getUsuario())) {
      String password = usuarios.get(desafioPassword.getUsuario()).getPassword();
      String passwordCifrada = Utils.cifraCesarPassword(password, SistemaSeguridadPassword.numeroCifradoCesar);
      if (passwordCifrada.equals(respuestaPassword.getRespuesta())) {
        return new Usuario(usuarios.get(desafioPassword.getUsuario()).getId());
      } else {
        return null;
      }
    } else {
      return null;
    }
  }
}
