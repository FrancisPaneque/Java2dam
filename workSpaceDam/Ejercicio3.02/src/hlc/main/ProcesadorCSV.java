package hlc.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hlc.utils.*;

public class ProcesadorCSV {

	public static void main(String[] args) {
		// Si no se ha introducido un solo parametro
		if (args.length != 1) {
			// Explica la forma de uso del programa y termina 
      System.out.println("Uso: java ProcesadorCSV archivo.csv");
      return;
		}
		
		// Toma el primer argumento 
	  String archivoCSV = args[0];
	
	  try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
	      String linea;
	      int numeroLinea = 0;
	      
	      // Mientras la linea leida sea distinta de null
	      while ((linea = br.readLine()) != null) {
	          numeroLinea++;
	          // Divide los campos cada que enecuetra comas 
	          String[] campos = linea.split(",");
	          
	          // Si hay mas o menos de 10 campos
	          if (campos.length != 10) {
	              System.out.println("Error en la línea " + numeroLinea + ": Número incorrecto de campos.");
	              continue;
	          }
	
	          try {
	          		// Comprueba cada campo
	              Utiles.validarCampos(campos);
	              // Si los datos son validos
	              System.out.println("Línea " + numeroLinea + ": Datos válidos.");
	          } catch (IllegalArgumentException e) {
	              System.out.println("Error en la línea " + numeroLinea + ": " + e.getMessage());
	          }
	      }
	
	  } catch (IOException e) {
	      e.printStackTrace();
	  }
	}

}
