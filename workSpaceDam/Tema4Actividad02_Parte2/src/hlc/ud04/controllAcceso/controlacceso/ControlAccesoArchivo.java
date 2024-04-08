package hlc.ud04.controllAcceso.controlacceso;

import java.util.Map;

import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.controllAcceso.persistencia.GestorPermisos;

/**
 * Clase que representa un control de acceso simple
 * Permite acceso total al usuario con ID 1, sólo lectura al 2
 * y escritura al 3. Cualquier otro ID no tiene acceso a nada
 * La operación y el recurso se ignoran
 */
public class ControlAccesoArchivo implements ControlAcceso {
	
	private String archivo = "permisos.txt";

  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
  	
  	GestorPermisos buscador = new GestorPermisos(archivo);
  	Map<String, String> salida = buscador.leerpermisos();
  	String permiso;
  	if (existeUsuario(usuario.getUid(), salida)) {
  		
  		permiso = salida.get(String.valueOf(usuario.getUid()));
  		
  		 // El usuario 1 tiene acceso a todo
      if (permiso.contains("w") && permiso.contains("r")) {
        return true;
      } else  if (permiso.contains("r")) {
        // El 2 tiene acceso sólo lectura
        return operacion == Operacion.LECTURA;
      } else if (permiso.contains("w")) {
        // El 3 sólo escritura
        return operacion == Operacion.ESCRITURA;
      } else {
        // Cualquier otro no tiene acceso
        return false;
      }
  	} else {
  		return false;
  	}
  }
  
  private boolean existeUsuario(long uid, Map<String, String> salida) {
  	String id = String.valueOf(uid);
  	
  	if (salida.get(id) != null) {
  		return true;
  	} else {
  		return false;
  	}
  }

}
