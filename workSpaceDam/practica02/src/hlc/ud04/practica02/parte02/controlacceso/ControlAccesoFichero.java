package hlc.ud04.practica02.parte02.controlacceso;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;

public class ControlAccesoFichero implements ControlAcceso {
  
  private Map<Long, Permisos> permisos;
  
  public ControlAccesoFichero(String fichero) {
    permisos = new HashMap<>();
    leePermisos(fichero);
  }

  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
    Permisos permisos = this.permisos.get(usuario.getUid());
    if (permisos != null) {
      return ((operacion == Operacion.LECTURA) && permisos.lectura)
        || ((operacion == Operacion.ESCRITURA) && permisos.escritura);
    } else {
      return false;
    }
  }

  private void leePermisos(String fichero) {
    try {
      List<String> lineas = Files.readAllLines(Path.of(fichero));
      for (String linea: lineas) {
        procesaLinea(linea);
      }
    } catch (IOException e) {}
  }

  private void procesaLinea(String linea) {
    if (linea.contains(":")) {
      String[] partes = linea.split(":");
      if (partes.length == 2) {
        try {
          long uid = Long.parseLong(partes[0]);
          Permisos permisos = new Permisos();
          if (partes[1].length() > 0) {
            if (partes[1].charAt(0) == 'r') {
              permisos.lectura = true;
            } else if (partes[1].charAt(0) == 'w') {
              permisos.escritura = true;
            } else {
              return;
            }
          }
          if (partes[1].length() > 1) {
            if (partes[1].charAt(1) == 'r') {
              if (!permisos.lectura) {
                permisos.lectura = true;
              } else {
                return;
              }
            } else if (partes[1].charAt(1) == 'w') {
              if (!permisos.escritura) {
                permisos.escritura = true;
              } else {
                return;
              }
            } else {
              return;
            }
          }
          // Almacenamos los permisos
          this.permisos.put(uid, permisos);
        } catch (Exception e) {}
      }
    }
  }
}

class Permisos {
  public boolean lectura = false;
  public boolean escritura = false;
}
