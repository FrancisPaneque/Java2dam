package main;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import utils.*;

public class ImageProcessingService {

	public static void main(String[] args) {
		try {
            // Cargar configuración desde el archivo config.properties
            Properties properties = Utilities.loadConfiguration();

            // Obtener la carpeta de entrada y salida
            Path inputFolder = Paths.get(properties.getProperty("inputfolder", ""));
            Path outputFolder = Paths.get(properties.getProperty("outputfolder", "output"));

            // Crear el directorio de salida si no existe
            if (!outputFolder.toFile().exists()) {
                outputFolder.toFile().mkdir();
            }

            // Iniciar el hilo maestro (dispatcher)
            Utilities.startDispatcher(inputFolder, outputFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
