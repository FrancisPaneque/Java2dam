 package hlc.ud04.controllAcceso.seguridad;

import java.util.Scanner;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;
import hlc.ud04.controllAcceso.autenticador.DesafioSecret;
import hlc.ud04.controllAcceso.autenticador.RespuestaDesafioPassword;

/**
 * Sistema de contraseña 
 * Usa el nombre del Usuario y su contraseña que tiene asociado a ese nombre.
 * El control de acceso empleado es simple. El usuario con ID 1 tiene acceso total
 * el de ID 2 sólo lectura y el de ID 3 sólo escritura. Cualquier otro ID no tiene acceso
 * @author Alvaro
 */

public class SistemaSeguridadPassword  implements SistemaSeguridad{
	
	//Autenticador
	 private Autenticador autenticador;
	 // Control de acceso
	 private ControlAcceso controlAcceso;
	 
	 /**
	  * Constructor
	  * @param autenticador Autenticador a usar
	  * @param controlAcceso Control de acceso a usar
	  */
	 public SistemaSeguridadPassword(Autenticador autenticador, ControlAcceso controlAcceso) {
	   this.autenticador = autenticador;
	   this.controlAcceso = controlAcceso;
	 }

	@Override
	public Usuario autentica() {
	// Scanner para interactuar con el usuario
    Scanner sc = new Scanner(System.in);
    
    // Solicita el nombre de usuario
    System.out.print("Introduzca el identificador del usuario: ");
    String usuario = sc.nextLine();
    
 // Crea un nuevo desafío 
    DesafioSecret desafio = (DesafioSecret) autenticador.iniciaAutenticacion(usuario);
    
    //Solicita la contraseña del usurio
    System.out.print("Introduzca la contraseña del usuario: ");
    String respuesta = sc.nextLine();
    
		return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioPassword(respuesta));
	}

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		return controlAcceso.estaPermitido(usuario, operacion, recurso);
	}

}