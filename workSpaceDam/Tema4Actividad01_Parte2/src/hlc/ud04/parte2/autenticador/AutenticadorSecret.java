package hlc.ud04.parte2.autenticador;

import java.util.Map;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.parte2.models.UsuarioSQlite;
import hlc.ud04.parte2.Persistencia.GestorSQLite;

public class AutenticadorSecret implements Autenticador {
	
	Map<String, UsuarioSQlite> usuarios;
	
	public AutenticadorSecret() {
    GestorSQLite proveedor = new GestorSQLite("jdbc:sqlite:db/base.db");
    usuarios = proveedor.leeUsuario();
  }
	@Override
		public Desafio iniciaAutenticacion(String usuario) {
			return new DesafioSecret(usuario, usuarios);
		}
	
	@Override
	public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
		DesafioSecret desafioSecret = (DesafioSecret)desafio;
    RespuestaDesafioSecret respuestaPassword = (RespuestaDesafioSecret)respuesta;
    if (usuarios.containsKey(desafioSecret.getNombre())) {
      String totp = desafioSecret.getClave();
      if (totp.equals(respuestaPassword.getRespuesta())) {
        return new Usuario(usuarios.get(desafioSecret.getNombre()).getId());
      } else {
        return null;
      }
    } else {
      return null;
    }
	}

	

}
