package psp.unidad02.actividad205.utils;

import java.util.Date;
import java.util.Properties;
import java.io.*;
import java.text.SimpleDateFormat;

/**
 * La clase ConfigurationFile proporciona métodos para cargar y acceder a la configuración desde un archivo.
 */
public class ConfigurationFile {
	
	// Valores por defecto
	private static final String DF_INPUT_FOLDER = "./input";
	private static final String DF_OUTPUT_FILE = "index.idx";
	
	// Claves del archivo de configuración
	private static final String KEY_INPUT_FOLDER = "inputFolder";
	private static final String KEY_OUTPUT_FILE = "outputFolder";
	
	// Variables estáticas accesibles desde otras clases
	public static String inputFolder;
	public static String outputFile;
	
    private Properties properties;

    /**
     * Constructor de la clase ConfigurationFile.
     *
     * @param filePath Ruta del archivo de configuración.
     */
    public ConfigurationFile(String filePath) {
    	properties = new Properties();
      try (InputStream input = new FileInputStream(filePath)) {
      	// Cargar propiedades desde el archivo
        properties.load(input);
            
        // Obtener valores de las propiedades o usar valores por defecto
        inputFolder = properties.getProperty(KEY_INPUT_FOLDER, DF_INPUT_FOLDER);
        outputFile = properties.getProperty(KEY_OUTPUT_FILE, DF_OUTPUT_FILE);
            
        // Si está vacío, establecer valores por defecto
        if (inputFolder.isBlank()) {
        	inputFolder = DF_INPUT_FOLDER;
        }
        if (outputFile.isBlank()) {
        	outputFile = DF_OUTPUT_FILE;
        }
      } catch (IOException e) {
      	// Manejar errores al cargar el archivo de configuración
        logProblem("Error loading configuration file (Default values set): " + e.getMessage());
        setDefaultValues();
      }
    }

    /**
     * Establece los valores predeterminados para las variables de configuración.
     * Este método se utiliza en caso de que no se puedan cargar valores desde el archivo de configuración.
     */
    public static void setDefaultValues() {
      inputFolder = DF_INPUT_FOLDER;
      outputFile = DF_OUTPUT_FILE;
    }

    /**
     * Registra un mensaje de problema en el log.
     *
     * @param message Mensaje de problema a registrar.
     */
    private void logProblem(String message) {
      // Log de mensajes de problema
      logMessage("PROBLEM", "ConfigurationFile", message);
    }

    /**
     * Registra un mensaje en el log.
     *
     * @param level   Nivel de importancia del mensaje.
     * @param module  Módulo o clase en el que se ha producido el mensaje.
     * @param message Cuerpo del mensaje.
     */
    private void logMessage(String level, String module, String message) {
      // Log de mensajes generales
      String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      System.out.println("[" + timestamp + "] (" + level + ") <" + module + ">: " + message);
    }
}