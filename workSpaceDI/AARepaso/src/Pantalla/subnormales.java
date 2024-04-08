package Pantalla;

import java.util.ArrayList;
import java.util.List;


public class subnormales {
	
	private String nombre;
	private String edad;
	private int id;
	private String sex;
	
	public static List<subnormales> lista = new ArrayList<>();
	
	public subnormales(String nombre, String edad, int id, String sex) {
		this.nombre = nombre;
		this.edad = edad;
		this.id = id;
		this.sex = sex;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
		
		public static void add(subnormales sub) {
			lista.add(sub);
		}
		
		/**
		 * Busca en la lista de los cliente que sea igual al email que se le pasa por parametro
		 * @param email
		 * @return cliente
		 */
		
		public static int busca(int id) {
			int cliente = 0;
			
			for(int i = 0; i < lista.size(); i++) {
				
				int ide = lista.get(i).getId();
				if (ide == id) {
					
					cliente = i;
				}
			}
			return cliente;
		}
		
		/**
		 * Mira si existe el Cliente en la lista 
		 * @param email
		 * @return true si existe, false si no existe
		 */
		public static boolean existe(int id) {
			for(int i = 0; i < lista.size(); i++) {
				
				int correo = lista.get(i).getId();
				if (correo == id) {
					return true;	
				}
			}
			
			return false;
		}
		
		/**
		 * Devuelve el cliete que este en la posicion que el parametro
		 * @param  i numero en la lista
		 * @return cliente
		 */
		public static subnormales devuelve(int i) {
			return lista.get(i);
		}
		
		public static int tamanioLista() {
			return lista.size();
			
		}
		
		
	

}
