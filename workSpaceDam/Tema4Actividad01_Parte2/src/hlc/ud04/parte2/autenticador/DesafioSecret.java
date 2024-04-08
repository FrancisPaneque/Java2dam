package hlc.ud04.parte2.autenticador;

import java.util.Map;

import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.parte2.auth.otp.GeneradorHOTP;
import hlc.ud04.parte2.models.UsuarioSQlite;

public class DesafioSecret implements Desafio {
	
	private String nombre;
	
	private Map<String, UsuarioSQlite> usuarios;
	
	public DesafioSecret(String nombre, Map<String, UsuarioSQlite> usuarios) {
		this.nombre = nombre;
		this.usuarios = usuarios;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Este metodo va devolver la clave TOTP
	 * @return the clave
	 */
	
	public String getClave() {
		GeneradorHOTP generador = new GeneradorHOTP();
		return generador.genera(usuarios.get(nombre).getSecreto(), System.currentTimeMillis() / 30000);
	}

}
