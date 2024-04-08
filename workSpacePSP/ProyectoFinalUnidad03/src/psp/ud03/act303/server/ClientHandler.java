package psp.ud03.act303.server;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

/**
 * Esta clase maneja las solicitudes de clientes entrantes en el servidor.
 * Implementa la interfaz Runnable para ejecutarse en un hilo separado.
 */
class ClientHandler implements Runnable {
  private final Socket clientSocket;

  /**
   * Constructor de la clase ClientHandler.
   * @param clientSocket El socket del cliente que manejará este handler.
   */
  public ClientHandler(Socket clientSocket) {
    this.clientSocket = clientSocket;
  }

  @Override
  public void run() {
    try (
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    ) {
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        String[] commandParts = inputLine.split(" ", 2);
        String command = commandParts[0].trim();
        String argument = commandParts.length > 1 ? commandParts[1].trim() : null;
        
        switch (command) {
          case "list":
            listFiles(out, argument);
            break;
          case "delete":
            deleteFile(out, argument);
            break;
          case "show":
            sendFileContent(out, argument);
            break;
          case "quit":
            out.println("OK");
            return;
          default:
            out.println("KO");
            break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Lista los archivos en una carpeta especificada.
   * @param out PrintWriter para enviar la respuesta al cliente.
   * @param folderPath Ruta de la carpeta.
   */
  private void listFiles(PrintWriter out, String folderPath) {
    File folder = new File(folderPath);
    if (!folder.exists() || !folder.isDirectory()) {
      out.println("KO");
      return;
    }
    
    File[] files = folder.listFiles();
    if (files != null && files.length > 0) {
      String cadena = "OK-";
      for (File file : files) {
        cadena += file.getName() + " " + file.length() + "-";
      }
      out.println(cadena);
    } else {
      out.println("OK pepe");
    }
  }

  /**
   * Elimina un archivo especificado.
   * @param out PrintWriter para enviar la respuesta al cliente.
   * @param filePath Ruta del archivo a eliminar.
   */
  private void deleteFile(PrintWriter out, String filePath) {
    File fileToDelete = new File(filePath);
    System.out.println(fileToDelete);
    if (fileToDelete.exists()) {
      if (fileToDelete.isDirectory() && fileToDelete.list().length == 0 || fileToDelete.isFile()) {
        fileToDelete.delete();
        out.println("OK");
      } else {
        out.println("KO");
      }
    } else {
      out.println("KO");
    }
  }

  /**
   * Envía el contenido de un archivo especificado al cliente.
   * @param out PrintWriter para enviar la respuesta al cliente.
   * @param filePath Ruta del archivo.
   */
  private void sendFileContent(PrintWriter out, String filePath) {
    Path path = Paths.get(filePath);
    try {
      List<String> lines = Files.readAllLines(path);
      String txt = "OK-";
      txt += lines.size() + "-";
      for (String line : lines) {
        txt+=line+"-";
      }
      out.println(txt);
    } catch (IOException e) {
      out.println("KO");
    }
  }
}