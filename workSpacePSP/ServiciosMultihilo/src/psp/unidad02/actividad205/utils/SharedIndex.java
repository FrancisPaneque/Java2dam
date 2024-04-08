package psp.unidad02.actividad205.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

import psp.unidad02.actividad205.models.*;

/**
 * Clase que representa un índice compartido para almacenar información sobre palabras encontradas en archivos.
 */
public class SharedIndex {

  // Mapa que almacena palabras y sus ocurrencias en forma de triplets (ver clase Triple).
  private Map<String, List<Triple>> index;

  /**
   * Constructor que inicializa la instancia de la clase.
   */
  public SharedIndex() {
    // Se utiliza ConcurrentHashMap para garantizar la seguridad en entornos multihilo sin bloqueos explícitos.
    index = new ConcurrentHashMap<>();
  }

  /**
   * Método para agregar una palabra al índice compartido.
   *
   * @param word       La palabra a agregar al índice.
   * @param fileName   El nombre del archivo en el que se encontró la palabra.
   * @param lineNumber El número de línea en el archivo donde se encontró la palabra.
   * @param position   La posición en la línea donde se encontró la palabra.
   */
  public void addWord(String word, String fileName, int lineNumber, int position) {
    // Utiliza computeIfAbsent para asegurarse de que se crea una lista para una palabra si aún no está presente.
    // CopyOnWriteArrayList permite lecturas concurrentes sin bloqueo.
    index.computeIfAbsent(word, k -> new CopyOnWriteArrayList<>())
         .add(new Triple(fileName, lineNumber, position));
  }

  /**
   * Método para guardar el contenido del índice en un archivo.
   *
   * @param outputFilePath La ruta del archivo donde se guardará el índice.
   */
  public void saveToFile(String outputFilePath) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
      // Itera sobre el índice y escribe cada palabra seguida de sus triplets en el archivo.
      for (Map.Entry<String, List<Triple>> entry : index.entrySet()) {
        writer.println(entry.getKey());
        for (Triple triple : entry.getValue()) {
          writer.println("  " + triple.toString());
        }
      }
    } catch (IOException e) {
      // Registra un mensaje de problema si hay un error al guardar el índice en el archivo.
      logProblem("Error saving index to file: " + e.getMessage());
    }
  }

  /**
   * Método privado para registrar mensajes de problema.
   *
   * @param message Mensaje del problema a registrar.
   */
  private void logProblem(String message) {
    // Utiliza logMessage para imprimir mensajes de problema en la consola con formato específico.
    logMessage("PROBLEM", "SharedIndex", message);
  }

  /**
   * Método privado para registrar mensajes con un formato específico.
   *
   * @param level   Nivel del mensaje (e.g., INFO, ERROR).
   * @param module  Módulo que emite el mensaje.
   * @param message Mensaje a registrar.
   */
  private void logMessage(String level, String module, String message) {
    // Obtiene la marca de tiempo actual en un formato específico.
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    // Imprime el mensaje en la consola con el formato [timestamp] (nivel) <modulo>: mensaje.
    System.out.println("[" + timestamp + "] (" + level + ") <" + module + ">: " + message);
  }
}