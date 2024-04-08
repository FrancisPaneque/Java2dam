package psp.ud03.act303.client;

import java.io.*;
import java.net.*;

/**
 * Esta clase representa la aplicación del cliente de archivos.
 */
public class FileClientApp {
  private static final String DEFAULT_HOST = "localhost";
  private static final int DEFAULT_PORT = 2121;

  public static void main(String[] args) {
    String host = DEFAULT_HOST;
    int port = DEFAULT_PORT;

    // Verificar si se proporcionaron argumentos de línea de comandos para el host y el puerto
    if (args.length >= 2) {
      host = args[0];
      port = Integer.parseInt(args[1]);
    }

    try (
        // Establecer la conexión con el servidor
        Socket socket = new Socket(host, port);
        // Configurar los flujos de entrada y salida para la comunicación con el servidor
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
    ) {
      // Indicar que se ha establecido la conexión con el servidor
      System.out.println("Conectado al servidor en " + host + ":" + port);
      String userInput;
      // Leer la entrada del usuario desde la consola
      while ((userInput = stdIn.readLine()) != null) {
        // Enviar la entrada del usuario al servidor
        out.println(userInput);
        // Leer la respuesta del servidor
        String response = in.readLine();
        // Mostrar la respuesta del servidor en la consola
        System.out.println("Respuesta del servidor: " + response.replace("-", "\n"));
        // Salir del bucle si el usuario ingresó "quit" y el servidor respondió "OK"
        if (response.equals("OK") && userInput.equals("quit")) {
          break;
        }
      }
    } catch (UnknownHostException e) {
      // Manejar el caso en el que no se puede encontrar el host
      System.err.println("No se puede encontrar el host " + host);
      System.exit(1);
    } catch (IOException e) {
      // Manejar errores de entrada/salida durante la conexión
      System.err.println("Error de entrada/salida para la conexión con " + host);
      System.exit(1);
    }
  }
}
