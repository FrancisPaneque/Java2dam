package hlc.ud04.autentificadorapp.controlacceso;

import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.autentificadorapp.utils.Utils;

/**
 * Clase que representa un control de acceso simple.
 * Permite acceso total al usuario con ID 1, sólo lectura al 2
 * y escritura al 3. Cualquier otro ID no tiene acceso a nada.
 * La operación y el recurso se ignoran.
 */
public class ControlAccesoSimple implements ControlAcceso {

  private final String rutaPropierties = "permisos.properties";

  /**
   * Verifica si el usuario tiene permiso para realizar una operación sobre un recurso.
   * @param usuario Usuario para verificar los permisos.
   * @param operacion Operación que se desea realizar.
   * @param recurso Recurso sobre el cual se desea realizar la operación (se ignora en este control de acceso).
   * @return true si el usuario tiene permiso para realizar la operación, false de lo contrario.
   */
  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
    String idUsuario = Long.toString(usuario.getUid());

    if (Utils.buscarValor(rutaPropierties, idUsuario).equals("ESCRITURA/LECTURA")) {
      return true;
    } else if (Utils.buscarValor(rutaPropierties, idUsuario).equals("LECTURA")) {
      return operacion == Operacion.LECTURA;
    } else if (Utils.buscarValor(rutaPropierties, idUsuario).equals("ESCRITURA")) {
      return operacion == Operacion.ESCRITURA;
    } else {
      // Cualquier otro no tiene acceso
      return false;
    }
  }
}