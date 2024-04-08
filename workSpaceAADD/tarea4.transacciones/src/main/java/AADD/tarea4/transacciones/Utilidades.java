package AADD.tarea4.transacciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import profesor.Profesor;
import asignatura.Asignatura;

public class Utilidades {

	private static String INSERT_EMPLEADO = "INSERT IN TO Profesor (NIF_P, NombreProfesor, Especialidad, TelefonoProfesor) VALUES (?, ?, ?, ?);";
	private static String INSERT_ASIGNATURA = "INSERT IN TO Asignatura (CodAsignatura, NombreAsignatura, IdProfesor ) VALUES (?, ?, ?);";
	
	public static List<Profesor> profesores = new ArrayList<>();
	public static List<Asignatura> asignaturas = new ArrayList<>();
	public static int numeroLineasProcesadas = 0;
	/**
	 * metodo que lee el fichero y dependiendo de la linea leida lo añade a una  otra lista
	 * @param nombreArchivo
	 * @throws IOException
	 */
	public static void leerArchivoLineaPorLinea(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        FileReader fileReader = new FileReader(archivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linea;

        while ((linea = bufferedReader.readLine()) != null) {
        	numeroLineasProcesadas+=1;
        	if (buscarPalabraEnCadena(linea, "Profesor")) {
        		String[] lineaDividida = divideCadena(linea);
        		Profesor profesor = new Profesor(lineaDividida[1], lineaDividida[2], lineaDividida[3], Integer.parseInt(lineaDividida[4]));
        		profesores.add(profesor);
        	} else if (buscarPalabraEnCadena(linea, "Asignatura")) {
        		String[] lineaDividida = divideCadena(linea);
        		Asignatura asignatura = new Asignatura(lineaDividida[1], lineaDividida[2]);
        		asignaturas.add(asignatura);
        	} else {
        		System.err.println("La linea leida no pertenece a ningun tipo de tabla de la base de datos");
        	}
        }

        bufferedReader.close();
    }
	
	/**
	 * busca la palabra en la cadena que determina el tipo de objeto que se creara y si la encuentra devuelve un true
	 * @param cadena
	 * @param palabra
	 * @return boolean
	 */
	public static boolean buscarPalabraEnCadena(String cadena, String palabra) {
        // Convierte la cadena y la palabra a minúsculas para hacer la búsqueda insensible a mayúsculas y minúsculas.
        cadena = cadena.toLowerCase();
        palabra = palabra.toLowerCase();

        // Busca la palabra en la cadena.
        int indice = cadena.indexOf(palabra);

        // Si el índice es diferente de -1, la palabra se encontró en la cadena.
        return indice != -1;
    }
	/**
	 * divide la cadena cada que encuentra ; y lo guarda en una array
	 * @param cadena
	 * @return arrayDeCadenas
	 */
	public static String[] divideCadena(String cadena) {
		//Divide la cadena cada que encuentra ;
		String[] cadenaDivida = cadena.split(";");
		return cadenaDivida;
	}
	/**
	 * Inserta un profesor en la tabla Profesor y da al objeto de la clase Profesor el IdProfesor
	 */
	public static void insertProfesor(Profesor profesor) {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			//Realizamos la conexion
			conexion = AADD.Conexion.Conexion.conexion();
			//Creamos el statement
			preparedStatement = conexion.prepareStatement(INSERT_EMPLEADO);
			//Indicamos los valores a insertar
			preparedStatement.setString(1, profesor.getNIF());
			preparedStatement.setString(2,profesor.getNombre());
			preparedStatement.setString(3, profesor.getEspecialidad());
			preparedStatement.setInt(4, profesor.getTelefono());
			
			int filasAfectadas = preparedStatement.executeUpdate();
			
			if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa.");

                // Obtener las claves generadas
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    profesor.setIdProfesor(idGenerado);
                }
            } else {
                System.out.println("La inserción no tuvo éxito.");
            }
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}
	
	/**
	 * Inserta en los valores en la tabla Asignatura
	 */
	public static void insertAsignatura(Asignatura asignatura, Profesor profesor) {
		Connection conexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			conexion = AADD.Conexion.Conexion.conexion();
			preparedStatement = conexion.prepareStatement(INSERT_ASIGNATURA);
			
			preparedStatement.setString(1, asignatura.getCodAsignatura());
			preparedStatement.setString(2, asignatura.getNombreAsignatura());
			preparedStatement.setInt(3, profesor.getIdProfesor());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static String indicaTipo(String nombreArchivo) throws IOException {
        File archivo = new File(nombreArchivo);
        FileReader fileReader = new FileReader(archivo);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linea;
        String tipo = null;
        while ((linea = bufferedReader.readLine()) != null) {
        	numeroLineasProcesadas+=1;
        	if (buscarPalabraEnCadena(linea, "Profesor")) {
        		String[] lineaDividida = divideCadena(linea);
        		tipo =  "Profesor";
        	} else if (buscarPalabraEnCadena(linea, "Asignatura")) {
        		String[] lineaDividida = divideCadena(linea);
        		tipo = "Asignatura";
        	} else {
        		System.err.println("La linea leida no pertenece a ningun tipo de tabla de la base de datos");
        	}
        }

        bufferedReader.close();
		return tipo;
    }
}
