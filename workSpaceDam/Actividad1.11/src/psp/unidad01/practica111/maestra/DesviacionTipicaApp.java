package psp.unidad01.practica111.maestra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.PrintWriter;
import psp.unidad01.practica111.esclava.EsclavaApp;

public class DesviacionTipicaApp {

	private static final int PROCESOS = cantidadProcesos();
	private static final String CLASE_ESCLAVO = "psp.unidad01.practica111.EsclavaApp";
	private static final String JAR_ESCLAVO = "Esclava.jar";
	private static final String RUTA_FICHERO_PROCESADO = "Ficheros/serieProcesado.txt";
	
	public static void main(String[] args) {
		
		if (args.length < 1) {
			
			System.err.println("Falta de parametros, Introduzca como parametro la ruta del fichero");
			//Finaliza el programa
			return;
			
		} else {
			//Creamos la factoria de procesos
			ProcessBuilder builder = new ProcessBuilder("java", "-jar",  JAR_ESCLAVO);
			
			// Creamos los procesos
	    List<Process> procesos = new ArrayList<>();
	    for (int i = 0; i < PROCESOS; i++) {
	      try {
					procesos.add(builder.start());
				} catch (IOException e) {
					System.err.println("Error al iniciar el proceso: " + e.getMessage());
					e.printStackTrace();
				}
	    }
	    
	    //Llamamos a los metodos necesarios
	    //Quita las comas del fichero pasado
	    procesaFichero(args);
	    //calculamos la media de numeros dentro del fichero
	    double media = calculaMedia();
	    //contamos el numero de valores que hay dentro del fichero
	    int cantidadDeValores = cantidadValores();
	    //Pasamos los valores del fichero a una lista
	    List<Double> listaFichero = pasaFicheroLista();
	    
	    //Pasamos los valores a los esclavos
	    int vuelta = 0;
	    for (Process proceso: procesos) {
	      BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
	      PrintWriter printer = new PrintWriter(escritor);
	      printer.print(media);
	      for (int i = vuelta * (cantidadDeValores / PROCESOS); i < ((vuelta + 1) * (cantidadDeValores / PROCESOS)); i++) {
	        printer.print(listaFichero.get(i));
	      }
	      printer.println();
	      printer.flush();
	      printer.close();
	      vuelta++;
	    }
	    
	    double sumaTotal = 0;
	    int exitCode = -1;
	    
	    //Recibe los valores de los esclavos
	    for (Process proceso: procesos) {
	      BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	      String linea;
	      try {
					while ((linea = reader.readLine()) != null) {
					  double resultado = Double.parseDouble(linea);
					  sumaTotal = sumaTotal + resultado;
					}
					exitCode = proceso.waitFor();
					proceso.destroy();
				} catch (NumberFormatException | IOException | InterruptedException e) {
					e.printStackTrace();
				}
	    }
	    
	    double divideSuma = sumaTotal / cantidadDeValores;
	    
	    double raizDivision = Math.sqrt(divideSuma);
	    
	    System.out.println(exitCode);
	    
	    System.out.println("Resultado: " + raizDivision);
	    
		}
  }
	/**
	 * Metodo que crea un fichero cambiando el formato del original cambiado ',' por '.' para trabajar con ellos
	 * @param args
	 */
	private static void procesaFichero(String[] args) {
		BufferedReader reader = null;
    PrintWriter writer = null;
    try {
      //Creamos los bufferes
			reader = new BufferedReader(new FileReader(args[0]));
			writer = new PrintWriter("Ficheros/serieProcesado.txt");
			//Variable que contiene cada linea leida del txt
			String linea = null;
      //Mientras que pueda leer lineas del primer txt
			while((linea = reader.readLine()) != null) {
        writer.println(linea.replace(",", "."));
			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	    try {
        if (reader != null) {
            reader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      } if (writer != null) {
      writer.close();
      }
	  }
	}
	/**
	 * Calcula la media de los valores dentro del fichero procesado
	 * @return media
	 */
	private static double calculaMedia() {
	  //hacemos la media de los numeros contados en el txtProcesado
    BufferedReader readerProcesado = null;
    //Variable que contiene cada linea leida del txt
		String lineaProcesada = null;
    //Valores necesarios para la media
		double sumaNumeros = 0;
		double numeroDeValores = 0;
	  //Mientras que pueda leer lineas del primer txt
		try {
			readerProcesado = new BufferedReader(new FileReader(RUTA_FICHERO_PROCESADO));
			while((lineaProcesada = readerProcesado.readLine()) != null) {
				sumaNumeros += Double.parseDouble(lineaProcesada);
				numeroDeValores+=1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	    try {
        if (readerProcesado != null) {
            readerProcesado.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
	  }
		
		double media = sumaNumeros / numeroDeValores;
		return media;
	}
	/**
	 * Cuenta el numero de valores que hay en la lista 
	 * @return cantidadValores
	 */
	private static int cantidadValores() {
	  //hacemos la media de los numeros contados en el txtProcesado
    BufferedReader readerProcesado = null;
    //Variable que contiene cada linea leida del txt
		String lineaProcesada = null;
    //Valores necesarios para la media
		int numeroDeValores = 0;
	  //Mientras que pueda leer lineas del primer txt
		try {
			readerProcesado = new BufferedReader(new FileReader(RUTA_FICHERO_PROCESADO));
			while((lineaProcesada = readerProcesado.readLine()) != null) {
				numeroDeValores+=1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	    try {
        if (readerProcesado != null) {
            readerProcesado.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
	  }
		
		return numeroDeValores;
	}
	/**
	 * Pasa el fichero procesado a lista
	 * @return listaFichero
	 */
	private static List<Double> pasaFicheroLista(){
		List<Double> listaFichero = new ArrayList<>();
	  
    BufferedReader readerProcesado = null;
    //Variable que contiene cada linea leida del txt
		String lineaProcesada = null;
	  //Mientras que pueda leer lineas del primer txt
		try {
			readerProcesado = new BufferedReader(new FileReader(RUTA_FICHERO_PROCESADO));
			while((lineaProcesada = readerProcesado.readLine()) != null) {
				listaFichero.add(Double.parseDouble(lineaProcesada));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	    try {
        if (readerProcesado != null) {
            readerProcesado.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
	  }
		
		return listaFichero;
	}
	/**
	 * Calcula la cantidad de procesadores que tiene nuestro equipo, para crear procesos
	 * @return cantidadProcesos
	 */
	public static int cantidadProcesos() {
		return Runtime.getRuntime().availableProcessors();
	}
	
}
