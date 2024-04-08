package hlc.ud04.parte2.segurad;

import java.util.Scanner;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;

import hlc.ud04.parte2.autenticador.AutenticadorSecret;
import hlc.ud04.parte2.controlAcceso.ControlAccesoSimple;
import hlc.ud04.parte2.autenticador.DesafioSecret;
import hlc.ud04.parte2.autenticador.RespuestaDesafioSecret;

public class SisitemaSeguridadTOTp implements SistemaSeguridad{
	
	private Autenticador autenticador;
	private ControlAcceso controlAcceso;

	public SisitemaSeguridadTOTp(AutenticadorSecret autenticador, ControlAccesoSimple controlAcceso) {
		this.autenticador = autenticador;
		this.controlAcceso = controlAcceso;
	}

	@Override
	public Usuario autentica() {
	// Scanner para interactuar con el usuario
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Introduzca el usuario: ");
    String usuario = sc.nextLine();
    
 // Crea un nuevo desafío 
    DesafioSecret desafio = (DesafioSecret) autenticador.iniciaAutenticacion(usuario);
    
    System.out.println("Clave: " + desafio.getClave());
    // Solicita la respuesta
    System.out.print("Introduzca la respuesta: ");
    String respuesta = sc.nextLine();
    
		return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioSecret(respuesta));
	}

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		return controlAcceso.estaPermitido(usuario, operacion, recurso);
	}

}
