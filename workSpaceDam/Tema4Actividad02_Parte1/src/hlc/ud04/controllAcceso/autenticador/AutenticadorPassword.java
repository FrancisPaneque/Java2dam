package hlc.ud04.controllAcceso.autenticador;

import java.util.Map;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.controllAcceso.persistencia.GestorPersistenciaSqliteUsuario;

public class AutenticadorPassword implements Autenticador {
	
	Map<String, UsuarioPassword> usuarios;
	
	public AutenticadorPassword() {
    GestorPersistenciaSqliteUsuario proveedor = new GestorPersistenciaSqliteUsuario("jdbc:sqlite:db/base.db");
    usuarios = proveedor.leeUsuario();
  }
	@Override
		public Desafio iniciaAutenticacion(String usuario) {
			return new DesafioSecret(usuario);
		}
	
	@Override
	public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
		DesafioSecret desafioPassword = (DesafioSecret)desafio;
    RespuestaDesafioPassword respuestaPassword = (RespuestaDesafioPassword)respuesta;
    if (usuarios.containsKey(desafioPassword.getUsuario())) {
      String password = usuarios.get(desafioPassword.getUsuario()).getPassword();
      if (password.equals(respuestaPassword.getRespuesta())) {
        return new Usuario(usuarios.get(desafioPassword.getUsuario()).getId());
      } else {
        return null;
      }
    } else {
      return null;
    }
	}

	

}
