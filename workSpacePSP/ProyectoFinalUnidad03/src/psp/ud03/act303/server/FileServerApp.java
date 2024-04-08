package psp.ud03.act303.server;

import java.io.*;
import java.net.*;
import java.util.Properties;

/**
 * Esta clase representa la aplicación del servidor de archivos.
 */
public class FileServerApp {
  private static final int DEFAULT_PORT = 2121;

  /**
   * El método principal de la aplicación.
   * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
   */
  public static void main(String[] args) {
    int port = DEFAULT_PORT;

    try {
      // Cargar la configuración del archivo server.properties
      Properties props = new Properties();
      FileInputStream fis = new FileInputStream("server.properties");
      props.load(fis);
      // Leer el puerto del archivo de configuración
      port = Integer.parseInt(props.getProperty("puerto", String.valueOf(DEFAULT_PORT)));
    } catch (IOException e) {
      // Si ocurre un error al cargar la configuración, se utiliza el puerto predeterminado
      e.printStackTrace();
    }

    try (ServerSocket serverSocket = new ServerSocket(port)) {
      // Esperar conexiones de clientes
      System.out.println("Servidor esperando conexiones en el puerto " + port + "...");

      while (true) {
        // Aceptar una conexión de cliente
        Socket clientSocket = serverSocket.accept();
        // Mostrar información sobre la conexión aceptada
        System.out.println("Cliente conectado: " + clientSocket);
        // Iniciar un hilo para manejar al cliente
        Thread clientThread = new Thread(new ClientHandler(clientSocket));
        clientThread.start();
      }
    } catch (IOException e) {
      // Si ocurre un error de entrada/salida, imprimir la traza del error
      System.out.println("Error de entrada o salida");
    	e.printStackTrace();
    }
  }
}