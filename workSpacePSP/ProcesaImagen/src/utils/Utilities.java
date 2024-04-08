package utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;
import java.io.FileInputStream;


public class Utilities {
	
	public static Properties loadConfiguration() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        }
        return properties;
    }

	public static void startDispatcher(Path inputFolder, Path outputFolder) throws IOException {
        // Iniciar el servicio de vigilancia
        WatchService watchService = FileSystems.getDefault().newWatchService();
        inputFolder.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        while (true) {
            try {
                WatchKey key = watchService.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        // Obtener la ruta completa del archivo creado
                        Path newFilePath = inputFolder.resolve((Path) event.context());

                        // Iniciar un nuevo hilo worker para procesar la imagen
                        ImageProcessingWorker worker = new ImageProcessingWorker(newFilePath, outputFolder);
                        new Thread(worker).start();
                    }
                }
                key.reset();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
	
}
