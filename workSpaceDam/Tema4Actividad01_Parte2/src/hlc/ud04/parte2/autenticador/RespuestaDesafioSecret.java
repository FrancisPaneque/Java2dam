package hlc.ud04.parte2.autenticador;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

public class RespuestaDesafioSecret implements RespuestaDesafio{

	private String respuesta;
	
	public RespuestaDesafioSecret(String respuesta) {
		this.respuesta = respuesta;
	}
	
	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}
}
