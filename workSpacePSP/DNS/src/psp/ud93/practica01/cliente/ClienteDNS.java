package psp.ud93.practica01.cliente;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * La clase ClienteDNS implementa un cliente simple que realiza consultas DNS al servidor DNS.
 */
public class ClienteDNS {

    /**
     * El método principal que inicia el cliente DNS.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        try {
            // Inicializa el socket del cliente y el scanner para la entrada del usuario.
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            boolean continuar = true;  // Variable que controla la ejecución del bucle.

            // Bucle principal del cliente.
            while (continuar) {
                System.out.print("Ingrese el nombre a consultar (o vacío para salir): ");
                String nombre = scanner.nextLine();

                // Si se ingresa un nombre vacío, sale del bucle.
                if (nombre.isEmpty()) {
                    continuar = false;  // Establece la variable continuar a false para salir del bucle.
                } else {
                    // Prepara y envía la consulta DNS al servidor.
                    byte[] buffer = nombre.getBytes();
                    InetAddress servidorAddress = InetAddress.getByName("localhost");
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, servidorAddress, 2222);

                    socket.send(packet);

                    // Recibe y muestra la respuesta del servidor.
                    buffer = new byte[1024];
                    packet = new DatagramPacket(buffer, buffer.length);

                    socket.receive(packet);

                    String respuesta = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("Respuesta del servidor: " + respuesta);
                }
            }

            // Cierra el socket y el scanner.
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
