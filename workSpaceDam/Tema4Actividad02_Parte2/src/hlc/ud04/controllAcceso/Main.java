package hlc.ud04.controllAcceso;

import hlc.ud04.appsec.core.Clientes;
import hlc.ud04.appsec.core.GestorPersistencia;
import hlc.ud04.appsec.interfaz.Interfaz;
import hlc.ud04.appsec.interfaz.consola.InterfazConsola;
import hlc.ud04.appsec.persistencia.GestorPersistenciaSqlite;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;
import hlc.ud04.controllAcceso.autenticador.AutenticadorPassword;
import hlc.ud04.controllAcceso.controlacceso.ControlAccesoArchivo;
import hlc.ud04.controllAcceso.seguridad.SistemaSeguridadPassword;

public class Main {
	
	 // Ruta a la base de datos en disco
  private static final String DATABASE_PATH = "db/base.db";
  
  public static void main(String[] args) {
    // Creamos el gestor de persistencia SQLite
    GestorPersistencia gestor = new GestorPersistenciaSqlite(DATABASE_PATH);
    // Y lo inyectamos en el core
    Clientes clientes = new Clientes(gestor);
    
    // Usamos nuestro sistema de seguridad
    SistemaSeguridad sistemaSeguridad = new SistemaSeguridadPassword(new AutenticadorPassword(),new ControlAccesoArchivo());
    
    // Creamos interfaz de usuario de tipo consola y le pasamos el sistema de seguridad
    Interfaz interfaz = new InterfazConsola(clientes, sistemaSeguridad);
    // Lanzamos la interfaz de usuario
    interfaz.run();
  }

}
