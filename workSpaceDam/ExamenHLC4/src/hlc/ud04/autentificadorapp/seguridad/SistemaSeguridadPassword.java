 package hlc.ud04.autentificadorapp.seguridad;

import java.util.Scanner;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;
import hlc.ud04.autentificadorapp.autenticador.DesafioSecret;
import hlc.ud04.autentificadorapp.autenticador.RespuestaDesafioPassword;
import hlc.ud04.autentificadorapp.utils.*;

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
	 //Numero cifra cesar
	 public static int numeroCifradoCesar;
	 
	 
	 /**
	  * Constructor
	  * @param autenticador Autenticador a usar
	  * @param controlAcceso Control de acceso a usar
	  */
	 public SistemaSeguridadPassword(Autenticador autenticador, ControlAcceso controlAcceso) {
	   this.autenticador = autenticador;
	   this.controlAcceso = controlAcceso;
	 }
	 
	 /**
	  * Método encargado de autenticar al usuario proporcionando su identificador y contraseña.
	  * Utiliza un escáner para interactuar con el usuario, solicitando su identificador y contraseña.
	  * Genera un desafío secreto utilizando el identificador proporcionado.
	  * Luego, solicita al usuario la contraseña cifrada con la cifra César generada previamente.
	  * Finalmente, utiliza el autenticador para verificar la autenticidad del usuario y devuelve el resultado.
	  * 
	  * @return El usuario autenticado si las credenciales son válidas, null en caso contrario.
	  */
	 @Override
	 public Usuario autentica() {
	     // Scanner para interactuar con el usuario
	     Scanner sc = new Scanner(System.in);
	     
	     // Solicita el nombre de usuario
	     System.out.print("Introduzca el identificador del usuario: ");
	     String usuario = sc.nextLine();
	     
	     // Crea un nuevo desafío 
	     DesafioSecret desafio = (DesafioSecret) autenticador.iniciaAutenticacion(usuario);
	     
	     // Genera numero cifra cesar
	     numeroCifradoCesar = Utils.generaRandomNumber();
	     
	     // Solicita la contraseña del usuario
	     System.out.print("Introduzca la contraseña del usuario, tras ser cifrada con la cifra cesar(" + numeroCifradoCesar + "):");
	     String respuesta = sc.nextLine();
	     
	     return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioPassword(respuesta));
	 }
	
	/**
	 * Determina si el usuario tiene permiso para realizar la operación especificada sobre el recurso dado.
	 * 
	 * @param usuario   El usuario cuyos permisos se están verificando.
	 * @param operacion La operación que el usuario intenta realizar.
	 * @param recurso   El recurso sobre el cual se realiza la operación.
	 * @return true si el usuario tiene permiso para realizar la operación sobre el recurso, false de lo contrario.
	 */
	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
	    return controlAcceso.estaPermitido(usuario, operacion, recurso);
	}
	
}
