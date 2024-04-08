package psp.unidad02.actividad205.models;

/**
 * La clase Triple representa una tripleta que contiene información sobre la ubicación de una palabra en un archivo.
 */
public class Triple {
  private String fileName;
  private int lineNumber;
  private int position;

  /**
   * Constructor de la clase Triple.
   *
   * @param fileName   El nombre del archivo donde se encuentra la palabra.
   * @param lineNumber El número de línea en el archivo donde se encuentra la palabra.
   * @param position   La posición de la palabra dentro de la línea.
   */
  public Triple(String fileName, int lineNumber, int position) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.position = position;
    }

  /**
   * Convierte la tripleta en una representación de cadena.
   *
   * @return Una cadena que representa la tripleta en el formato "(fileName, lineNumber, position)".
   */
  @Override
  public String toString() {
    return "(" + fileName + "," + lineNumber + "," + position + ")";
  }
}