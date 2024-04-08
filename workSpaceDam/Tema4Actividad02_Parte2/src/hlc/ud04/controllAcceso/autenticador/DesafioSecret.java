package hlc.ud04.controllAcceso.autenticador;

import hlc.ud04.appsec.seguridad.autenticacion.Desafio;

public class DesafioSecret implements Desafio {
	
	private String usuario;
	  
	  public DesafioSecret(String usuario) {
	    this.usuario = usuario;
	  }
	
	  /**
	   * @return the usuario
	   */
	  public String getUsuario() {
	    return usuario;
	  }
}
