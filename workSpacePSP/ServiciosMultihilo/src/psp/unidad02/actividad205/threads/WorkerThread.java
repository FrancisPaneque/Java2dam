package psp.unidad02.actividad205.threads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import psp.unidad02.actividad205.utils.SharedIndex;

/**
 * Clase que representa un hilo de trabajador para procesar un archivo y actualizar un índice compartido.
 */
public class WorkerThread extends Thread {

  // Ruta del archivo que procesará el hilo
  private String filePath;

  // Instancia de SharedIndex para compartir un índice entre múltiples hilos
  private SharedIndex sharedIndex;

  /**
   * Constructor de la clase WorkerThread.
   *
   * @param filePath     Ruta del archivo que procesará el hilo.
   * @param sharedIndex  Instancia de SharedIndex para compartir un índice entre múltiples hilos.
   */
  public WorkerThread(String filePath, SharedIndex sharedIndex) {
    this.filePath = filePath;
    this.sharedIndex = sharedIndex;
  }

  /**
   * Método run, ejecutado cuando el hilo se inicia. Lee el archivo línea por línea y procesa cada línea.
   */
  @Override
  public void run() {
    // Uso de try-with-resources para asegurar la correcta gestión del archivo
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      // Lectura de cada línea del archivo
      String line;
      int lineNumber = 1;
      while ((line = reader.readLine()) != null) {
    	// Procesamiento de cada línea
        processLine(line, lineNumber++);
      }
    } catch (IOException e) {
      // Manejo de excepciones de lectura de archivo
      logProblem("Error processing file: " + e.getMessage());
    }
  }

  /**
   * Procesa una línea del archivo, dividiéndola en palabras y agregándolas al índice compartido.
   *
   * @param line       Línea del archivo a procesar.
   * @param lineNumber Número de línea en el archivo.
   */
  private void processLine(String line, int lineNumber) {
    // Dividir la línea en palabras usando espacios como delimitador
    String[] words = line.split("\\s+");
    // Iterar sobre cada palabra en la línea
    for (int i = 0; i < words.length; i++) {
      // Limpiar la palabra de caracteres no alfabéticos y convertirla a minúsculas
      String word = words[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
      // Verificar si la palabra no está vacía y agregarla al índice compartido
      if (!word.isEmpty()) {
        sharedIndex.addWord(word, new File(filePath).getName(), lineNumber, i + 1);
      }
    }
  }

  /**
   * Registra un problema en la salida estándar.
   *
   * @param message Mensaje del problema.
   */
  private void logProblem(String message) {
    // Loguear el mensaje de problema
    logMessage("PROBLEM", "WorkerThread", message);
  }

  /**
   * Registra un mensaje en la salida estándar.
   *
   * @param level   Nivel del mensaje (e.g., INFO, ERROR).
   * @param module  Módulo que emite el mensaje.
   * @param message Mensaje a registrar.
   */
  private void logMessage(String level, String module, String message) {
    // Obtener la marca de tiempo formateada
    String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    // Imprimir el mensaje con nivel, módulo y marca de tiempo
    System.out.println("[" + timestamp + "] (" + level + ") <" + module + ">: " + message);
  }
}