package hlc.ud04.controllAcceso.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hlc.ud04.controllAcceso.autenticador.PermisosUsuario;

public class GestorPermisos {

	private String archivo;
	private Map<String, String> salida;
	private BufferedReader reader;
	
	public GestorPermisos(String archivo) {
		this.archivo = archivo;
	}

	public Map<String, String> leerpermisos() {
		salida = new HashMap<>();
		String linea;
		String[] lineaSeparada;
		try {
			reader = new BufferedReader(new FileReader(archivo));
			while (( linea= reader.readLine()) != null) {
				lineaSeparada = separaLinea(linea);
				salida.put(lineaSeparada[0], lineaSeparada[1]);
			}
			return salida;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String[] separaLinea(String linea) {
		return linea.split(":");
	}
}
