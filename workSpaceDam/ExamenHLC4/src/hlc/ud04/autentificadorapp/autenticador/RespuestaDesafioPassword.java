package hlc.ud04.autentificadorapp.autenticador;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

/**
 * Clase que representa la respuesta al desafio de la password
 *
 */
public class RespuestaDesafioPassword implements RespuestaDesafio {

	private String respuesta;
	
	/**
	 * Constructor de la clase RespuestaDesafioPassword
	 * @param respuesta
	 */
	public RespuestaDesafioPassword(String respuesta) {
		this.respuesta = respuesta;
		
	}
	
	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}
	

}
