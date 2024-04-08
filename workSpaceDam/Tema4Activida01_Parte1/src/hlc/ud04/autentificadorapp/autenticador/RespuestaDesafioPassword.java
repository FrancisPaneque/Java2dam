package hlc.ud04.autentificadorapp.autenticador;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

public class RespuestaDesafioPassword implements RespuestaDesafio {
	
	private String respuesta;

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
