package psp.ud03.ejemplos.echoudp.cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteEchoApp {

  // Constantes
  // Puerto por defecto en el que escucha este cliente
  private static final int MY_DEFAULT_PORT = 1235;
  // Dirección por defectodel servidor
  private static final String DEFAULT_OTHER_HOST = "localhost";
  // Puerto por defecto del servidor
  private static final int DEFAULT_OTHER_PORT = 1234;
  // Longitud del buffer de envío / recepción
  private static final int BUFFER_LENGTH = 1024;
  
  // Puerto en el que escucha este cliente
  private int port;
  // Host del servidor
  private String serverHost;
  // Puerto del Servidor
  private int serverPort;
  
  // Scanner para leer desde teclado
  Scanner sc;
  
  public ClienteEchoApp(String[] args) {
    // Procesa los parámetros
    processParameters(args);
    sc = new Scanner(System.in);
  }
  
  public static void main(String[] args) {
    // Crea una instancia de la clase
    ClienteEchoApp app = new ClienteEchoApp(args);
    // Y la lanza
    app.run();
    
  }

  private void processParameters(String[] args) {
    // En todos funciona igual
    // Se trata de extraer el parámetro del array de argumentos
    // Si se puede, se toma y si ocurre algún error se toma el valor por defecto correspondiente
    try {
      serverHost = args[0];
    } catch (Exception e) {
      serverHost = DEFAULT_OTHER_HOST;
    }
    try {
      serverPort = Integer.parseInt(args[1]);
    } catch (Exception e) {
      serverPort = DEFAULT_OTHER_PORT;
    }
    try {
      port = Integer.parseInt(args[2]);
    } catch (Exception e) {
      port = MY_DEFAULT_PORT;
    }
  }

  private void run() {
    // Creamos el socket para enviar y recibir
    // Lo creamos con try con recursos para que se cierre al terminar
    try (DatagramSocket socket = new DatagramSocket(port)) {

      // Mientras no se introduzca la cadena vacía
      String messageContent;
      do {
        // Lee el mensaje desde teclado
        System.out.print("Introduzca el mensaje a enviar (vacio para acabar): ");
        messageContent = sc.nextLine();
        // Si no es el mensaje de fin
        if (messageContent.length() > 0) {
          // Crea el paquete con el texto del mensaje
          byte[] messageBytes = messageContent.getBytes();
          DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, InetAddress.getByName(serverHost), serverPort);
          // Lo envía
          socket.send(packet);
          // Recibe la respuesta
          DatagramPacket response = new DatagramPacket(new byte[BUFFER_LENGTH], BUFFER_LENGTH);
          socket.receive(response);
          String receivedMessage = new String(response.getData(), response.getOffset(), response.getLength());
          // Y la imprime
          System.out.println("Respuesta recibida: " + receivedMessage);
        }
      } while (messageContent.length() > 0);
      System.out.println("Terminando...");
    } catch (IOException e) {
      System.err.println("Error en la conexión.");
      System.err.println("Excepcion original:");
      e.printStackTrace(System.err);
    }
  }

}
