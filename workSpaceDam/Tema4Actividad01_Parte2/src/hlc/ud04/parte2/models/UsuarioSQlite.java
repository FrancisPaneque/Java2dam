package hlc.ud04.parte2.models;

public class UsuarioSQlite {
	
	private String nombre;
	private String secreto;
	private int id;
	
	
	public UsuarioSQlite(String nombre, String secreto, int id) {
		this.nombre = nombre;
		this.secreto = secreto;
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the secreto
	 */
	public String getSecreto() {
		return secreto;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	

}
