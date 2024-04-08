package hlc.ud04.controllAcceso.controlacceso;

import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.controllAcceso.autenticador.BuscadorPermisos;
import hlc.ud04.controllAcceso.autenticador.UsuarioPassword;

/**
 * Clase que representa un control de acceso simple
 * Permite acceso total al usuario con ID 1, sólo lectura al 2
 * y escritura al 3. Cualquier otro ID no tiene acceso a nada
 * La operación y el recurso se ignoran
 */
public class ControlAccesoMascara implements ControlAcceso {

  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
  	BuscadorPermisos buscador = new BuscadorPermisos();
  	int permiso = buscador.buscaPorId((int) usuario.getUid());
    // El usuario 1 tiene acceso a todo
    if ((permiso & 100) != 0) {
      return true;
    } else  if ((permiso & 010) != 0) {
      // El 2 tiene acceso sólo lectura
      return operacion == Operacion.LECTURA;
    } else if ((permiso & 001) != 0) {
      // El 3 sólo escritura
      return operacion == Operacion.ESCRITURA;
    } else {
      // Cualquier otro no tiene acceso
      return false;
    }
  }

}
