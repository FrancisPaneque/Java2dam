package psp.ud03.practica02.cliente;

import java.io.*;
import java.net.Socket;

/**
 * Clase principal del cliente para el servicio de transferencia de archivos.
 */
public class MainClienteApp {
    /**
     * Método principal que inicia la aplicación del cliente.
     *
     * @param args Argumentos de línea de comandos: [0] dirección IP del servidor (opcional), [1] puerto del servidor (opcional).
     */
    public static void main(String[] args) {
        // Configuración predeterminada del servidor y puerto
        String servidor = (args.length > 0) ? args[0] : "localhost";
        int puerto = (args.length > 1) ? Integer.parseInt(args[1]) : 4321;

        try (
            // Se establece la conexión con el servidor
            Socket socket = new Socket(servidor, puerto);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            InputStream inputStream = socket.getInputStream()
        ) {
            // Solicitar al usuario la ruta del archivo
            System.out.println("Introduce la ruta del archivo:");
            String ruta = reader.readLine();

            // Enviar la solicitud al servidor
            writer.println(ruta);

            // Leer la respuesta del servidor
            String respuesta = reader.readLine();
            if ("OK".equals(respuesta)) {
                // Recibir y guardar el archivo en el cliente
                byte[] buffer = new byte[1024];
                int bytesRead;

                FileOutputStream fileOutputStream = new FileOutputStream(new File(getFileName(ruta)));
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                fileOutputStream.close();

                System.out.println("Archivo recibido y guardado exitosamente.");

            } else {
                System.out.println("Error: No se puede acceder al archivo en el servidor.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para extraer el nombre del archivo de la ruta completa.
     *
     * @param ruta Ruta completa del archivo.
     * @return Nombre del archivo extraído de la ruta.
     */
    private static String getFileName(String ruta) {
        // Extraer el nombre del archivo de la ruta
        int lastSeparatorIndex = Math.max(ruta.lastIndexOf('/'), ruta.lastIndexOf('\\'));
        return ruta.substring(lastSeparatorIndex + 1);
    }
}
