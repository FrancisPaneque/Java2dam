package AADD.tarea4.transacciones;
import Usuarios.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AADD.Conexion.Conexion;

public class Utilidades {

	private static String INSERT_USUARIOS = "INSERT INTO Superusuarios (nombre, apellidos, user) VALUES (?, ?, ?)";
	
	public static List<Usuario> usuarios = new ArrayList<>();

	/**
	 * metodo que lee el fichero y añade el usuario a la lista
	 * @param nombreArchivo
	 * @throws IOException
	 */
	public static void leerArchivoLineaPorLinea(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        FileReader fileReader = new FileReader(archivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linea;
        //añade a la lista usuarios el usuario con nombre y apellidos
        while ((linea = bufferedReader.readLine()) != null) {
        	
        	String[] lineaDividida = divideCadena(linea);
    		Usuario usuario = new Usuario(lineaDividida[1], lineaDividida[0]);
    		usuarios.add(usuario);
        }
        //cierra conexion
        bufferedReader.close();
        //añade el campo user a cadad usuario de la lista
        createUser(usuarios);
    }
	
	/**
	 * divide la cadena cada que encuentra ; y lo guarda en una array
	 * @param cadena
	 * @return arrayDeCadenas
	 */
	public static String[] divideCadena(String cadena) {
		//Divide la cadena cada que encuentra ;
		String[] cadenaDivida = cadena.split(",");
		return cadenaDivida;
	}
	
	/**
	 * Inserta en los valores en la tabla Asignatura
	 */
	public static void insertUsuarios() {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
       	    conexion = AADD.Conexion.Conexion.conexion();
            
            // Crear un PreparedStatement para cada tipo de sentencia
            PreparedStatement insertStatement = conexion.prepareStatement(INSERT_USUARIOS);
                        
            // Ejecutar en lotes de 10 sentencias
            int i = 0;
            for (Usuario usuario : usuarios) {
            	if (i % 10 == 0) {
                    conexion.setAutoCommit(false); // Deshabilitar la confirmación automática
                }
                
                if (i < 10) {
                    insertStatement.setString(1, usuario.getNombre());
                    insertStatement.setString(2, usuario.getApellidos());
                    insertStatement.setString(3, usuario.getUser());
                    insertStatement.addBatch();
                } 
                
                if (i % 10 == 9) {
                    insertStatement.executeBatch(); // Ejecutar lote de inserciones
                    conexion.commit(); // Confirmar el lote
                    conexion.setAutoCommit(true); // Habilitar la confirmación automática nuevamente
                }
                
                i++;
            }
            
            // Cerrar los PreparedStatement y la conexión
            insertStatement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * Metodo que crea la tabla Superusuario si no existe en nuestra base de datos
	 * @param nombreArchivo
	 */
	public static void crearTablaSuperusuarios () {
		// Sentencia SQL para crear la tabla
        String sql = "CREATE TABLE Superusuarios(" +
                     "idUser INT AUTO_INCREMENT PRIMARY KEY," +
                     "nombre VARCHAR(255)," +
                     "apellidos VARCHAR(255)," +
                     "user CHAR(8));";

        try (
            // Establecer conexión con la base de datos
            Connection connection = Conexion.conexion();
            // Crear un objeto Statement
            Statement statement = connection.createStatement()
        ) {
            // Ejecutar la sentencia SQL
            statement.executeUpdate(sql);
            System.out.println("Tabla creada exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * metodo que añade el campo user a cada objeto usuario
	 * @param usuarios
	 */
	public static void createUser(List<Usuario> usuarios) {
		
		for (Usuario usuario : usuarios) {
			
			char inicialNombre = usuario.getNombre().charAt(0);
			char inicialNombre2 = usuario.getNombre().charAt(1);
			String inicialesApellidos = tomaIniciales(usuario.getApellidos());
			
			String user = "2DAM" + inicialNombre + inicialNombre2 + inicialesApellidos;
			
			usuario.setUser(user);
		}
	}
	
	/**
	 * divide el apellido para tomar la inicial de primero y el segundo
	 * @param apellidos
	 * @return inicialesApellidos
	 */
	private static String tomaIniciales(String apellidos) {
		String[] apellidoDividido = apellidos.split(" ");
		
		char primeraInicial = apellidoDividido[0].charAt(0);
		if (apellidoDividido.length > 1) {
			char segundaInicial = apellidoDividido[1].charAt(0);
			String inicialesApellidos = primeraInicial + "" + segundaInicial;
			return inicialesApellidos;
		} else {
			String inicialesApellidos = primeraInicial+"";
			return inicialesApellidos;
		}
		
		
	}
}
