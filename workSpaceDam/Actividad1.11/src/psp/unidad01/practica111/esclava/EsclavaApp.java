package psp.unidad01.practica111.esclava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EsclavaApp {
	
	public static void main(String[] args) {
		
		List<Double> contenido = new ArrayList<>();
		String linea;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			double media = Double.parseDouble(reader.readLine());
			
			while ((linea = reader.readLine()) != null && !linea.isEmpty()) {
				contenido.add(Double.parseDouble(linea));
			}
			
			//Llamamos a los métodos necesarios
			List<Double> listaResta = restaMedia(media, contenido);
			List<Double> listaCuadrados = cuadradoDeLaResta(listaResta);
			double sumaTotal = sumaTotal(listaCuadrados);
			
			System.out.println(sumaTotal);
			System.out.flush();
			System.exit(0);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	
	
	/**
	 * Metodo que devuelve una lista String a lista Double
	 * @param contenido
	 * @return listaADouble
	 */
	private static List<Double> listaADouble(List<String> contenido){
		List<Double> listaADouble = new ArrayList<>();
		double numeroDouble;
		for (String cadena : contenido) {
			numeroDouble = Double.parseDouble(cadena);
			listaADouble.add(numeroDouble);
		}
		return listaADouble;
		
	}
	/**
	 * Metodo que devulve la media que es el valor que hay en la primera posicion de la lista
	 * @param listaADouble
	 * @return media
	 */
	private static Double devuelveMedia(List<Double> listaADouble) {
		double media = listaADouble.get(0);
		return media;
	}
	/**
	 * Metodo que resta a cada valor de listaADouble la media y lo añade a una lista
	 * @param media
	 * @param listaADouble
	 * @return restaMedia
	 */
	private static List<Double> restaMedia(double media, List<Double> listaADouble){
		List<Double> restaMedia = new ArrayList<>();
		
		double resta;
		
		for(int i = 1; i < listaADouble.size(); i++) {
			resta = listaADouble.get(i) - media;
			restaMedia.add(resta);
		}
		return restaMedia;
	}
	/**
	 * Metodo que realiza el cuadrado de cada valor de la lista restaMedia
	 * @param restaMedia
	 * @return cuadradoLista
	 */
	private static List<Double> cuadradoDeLaResta(List<Double> restaMedia) {
		List<Double> cuadradoLista = new ArrayList<>();
		double cuadrado;
		for (Double valor : restaMedia) {
			cuadrado = valor * valor;
			cuadradoLista.add(cuadrado);
		}
		return cuadradoLista;
	}
	/**
	 * Metodo que da el resultado de la suma total de los cuadrado de la resta de la media de cada valor de la primera lista
	 * @param cuadradoLista
	 * @return
	 */
	private static Double sumaTotal(List<Double> cuadradoLista) {
		double total = 0;
		for (Double valor : cuadradoLista) {
			total = valor + total;
		}
		return total;
	}
	
}
