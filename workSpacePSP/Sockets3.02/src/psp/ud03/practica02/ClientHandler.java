package psp.ud03.practica02;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Esta clase maneja las solicitudes de los clientes conectados al servidor.
 * Cada instancia de esta clase se ejecuta en un hilo separado para manejar las solicitudes concurrentemente.
 */
public class ClientHandler implements Runnable {
    private final Socket clientSocket;

    /**
     * Constructor que recibe el socket del cliente.
     *
     * @param clientSocket Socket del cliente que se va a manejar.
     */
    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * Método principal que se ejecuta cuando se inicia el hilo.
     * Maneja la solicitud del cliente y envía la respuesta correspondiente.
     */
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Lee la ruta del archivo enviada por el cliente
            String ruta = reader.readLine();
            System.out.println("Recibida solicitud para: " + ruta);

            // Lógica para enviar el archivo solicitado
            sendFile(ruta, writer);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierra la conexión con el cliente, independientemente del resultado
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Envía el archivo solicitado al cliente si existe en el servidor.
     *
     * @param ruta   Ruta del archivo solicitado.
     * @param writer PrintWriter para enviar la respuesta al cliente.
     */
    private void sendFile(String ruta, PrintWriter writer) {
        try {
            Path filePath = Paths.get(ruta);

            if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
                // Envia la respuesta OK al cliente
                writer.println("OK");

                // Envía el archivo en formato binario
                byte[] fileData = Files.readAllBytes(filePath);
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(fileData);

                System.out.println("Archivo enviado exitosamente.");

            } else {
                // Envía la respuesta KO al cliente si el archivo no existe
                writer.println("KO");
                System.out.println("Error: Archivo no encontrado en el servidor.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
