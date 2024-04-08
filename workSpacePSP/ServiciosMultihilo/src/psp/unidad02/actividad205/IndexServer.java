package psp.unidad02.actividad205;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import psp.unidad02.actividad205.utils.*;
import psp.unidad02.actividad205.threads.*;

/**
 * Clase principal que inicia el servidor de indexación. Monitoriza una carpeta de entrada
 * para procesar archivos de texto (.txt) y almacena un índice compartido en un archivo de salida.
 */
public class IndexServer {

	// Variable booleana para controlar la ejecución del dispatcher
  private static volatile boolean isRunning = true;

  /**
   * Punto de entrada principal del programa.
   *
   * @param args Los argumentos de la línea de comandos (no utilizados en este caso).
   */
  public static void main(String[] args) {
  	// Configuración: Lee las opciones desde el archivo server.properties
    ConfigurationFile config = new ConfigurationFile("server.properties");
        
    // Contador de archivos .txt procesados (almacenado en un arreglo para ser efectivamente final)
    final int[] txtFilesProcessed = {0};

    // Instancia compartida para almacenar el índice
    SharedIndex sharedIndex = new SharedIndex();

    // Hilo principal (dispatcher) para procesar archivos en la carpeta de entrada
    Thread dispatcher = new Thread(() -> {
    	try {
    		while (isRunning) {
    			// Lista de archivos en la carpeta de entrada
          File[] files = new File(ConfigurationFile.inputFolder).listFiles();

          if (files != null) {
          	for (File file : files) {
          		String fileName = file.getName();
              String filePath = file.getAbsolutePath();

              // Si el archivo tiene extensión .txt, crea un hilo worker para procesarlo
              if (fileName.endsWith(".txt")) {
              	WorkerThread workerThread = new WorkerThread(filePath, sharedIndex);
                logInfo("Comienza el procesamiento del archivo: " + fileName);
                workerThread.start();
                workerThread.join(); // Espera a que el hilo worker termine el procesamiento
                txtFilesProcessed[0]++;
              }
            }

            // Una vez se han procesado todos los archivos .txt, busca el archivo .end
            if (txtFilesProcessed[0] > 0) {
            	for (File file : files) {
            		String fileName = file.getName();
                String filePath = file.getAbsolutePath();

                // Si el archivo tiene extensión .end, guarda el índice y finaliza la aplicación
                if (fileName.endsWith(".end")) {
                	sharedIndex.saveToFile(ConfigurationFile.outputFile);
                  isRunning = false; // Detiene el hilo dispatcher
                  logInfo("Se ha procesado el archivo .end. Saliendo del programa.");
                }
              }
            }
          }

          // Espera antes de volver a verificar la carpeta de entrada
          Thread.sleep(1000); // Espera 1 segundo (puedes ajustar el intervalo según tus necesidades)
        }
      } catch (InterruptedException e) {
      	// Manejo de problemas durante el procesamiento
        logProblem("Error in dispatcher: " + e.getMessage());
      }
    });

    	// Configuración de prioridad del hilo principal
      dispatcher.setPriority(Thread.MAX_PRIORITY);

      // Inicia el hilo principal (dispatcher)
      dispatcher.start();
  }

  /**
   * Registra un mensaje de problema en el log.
   *
   * @param message El mensaje de problema a registrar.
   */
  private static void logProblem(String message) {
  	logMessage("PROBLEM", "IndexServer", message);
  }

  /**
  * Registra un mensaje informativo en el log.
  *
  * @param message El mensaje informativo a registrar.
  */
  private static void logInfo(String message) {
  	logMessage("INFO", "IndexServer", message);
  }

  /**
   * Registra un mensaje con nivel y módulo en el log.
   *
   * @param level   El nivel del mensaje (por ejemplo, "INFO" o "PROBLEM").
   * @param module  El módulo o clase en el que se ha producido el mensaje.
   * @param message El cuerpo del mensaje.
   */
  private static void logMessage(String level, String module, String message) {
  	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    System.out.println("[" + timestamp + "] (" + level + ") <" + module + ">: " + message);
  }
}