package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import java.io.FileInputStream;


public class ImageProcessingWorker implements Runnable {

	private Path inputFilePath;
    private Path outputFolder;

    public ImageProcessingWorker(Path inputFilePath, Path outputFolder) {
        this.inputFilePath = inputFilePath;
        this.outputFolder = outputFolder;
    }

    @Override
    public void run() {
        try {
            // Verificar si el archivo es una imagen JPG
            if (inputFilePath.toString().toLowerCase().endsWith(".jpg")) {
                // Leer la imagen original
                BufferedImage originalImage = ImageIO.read(inputFilePath.toFile());

                // Obtener las dimensiones máximas
                int maxWidth = Integer.parseInt(loadConfiguration().getProperty("maxwidth", "100"));
                int maxHeight = Integer.parseInt(loadConfiguration().getProperty("maxheight", "100"));

                // Procesar la imagen
                BufferedImage processedImage = processImage(originalImage, maxWidth, maxHeight);

                // Guardar la imagen procesada en la carpeta de salida
                File outputFile = outputFolder.resolve(inputFilePath.getFileName()).toFile();
                ImageIO.write(processedImage, "jpg", outputFile);

                // Eliminar el archivo original
                inputFilePath.toFile().delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage processImage(BufferedImage originalImage, int maxWidth, int maxHeight) {
    	int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        // Verificar si la imagen necesita ser redimensionada
        if (originalWidth > maxWidth || originalHeight > maxHeight) {
            // Calcular nuevas dimensiones manteniendo la proporción original
            double aspectRatio = (double) originalWidth / originalHeight;
            int newWidth = (int) Math.min(originalWidth, maxWidth);
            int newHeight = (int) (newWidth / aspectRatio);

            // Verificar si la altura calculada excede la altura máxima permitida
            if (newHeight > maxHeight) {
                newHeight = maxHeight;
                newWidth = (int) (newHeight * aspectRatio);
            }

            // Crear una nueva imagen redimensionada
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);

            return resizedImage;
        } else {
            // No es necesario redimensionar, devolver la imagen original
            return originalImage;
        }
    }

    private Properties loadConfiguration() throws IOException {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            properties.load(input);
        }
        return properties;
    }

}
