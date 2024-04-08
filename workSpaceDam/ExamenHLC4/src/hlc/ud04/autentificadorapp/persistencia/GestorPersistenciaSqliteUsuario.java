package hlc.ud04.autentificadorapp.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;

import hlc.ud04.autentificadorapp.autenticador.UsuarioPassword;

/**
 * Clase que gestiona la persistencia de usuarios utilizando una base de datos SQLite.
 */
public class GestorPersistenciaSqliteUsuario {

  private String database;

  /**
   * Constructor de la clase GestorPersistenciaSqliteUsuario.
   * @param database Ruta de la base de datos SQLite.
   */
  public GestorPersistenciaSqliteUsuario(String database) {
    this.database = database;
  }

  /**
   * Lee los usuarios almacenados en la base de datos.
   * @return Mapa de usuarios (nombre de usuario como clave y objeto UsuarioPassword como valor).
   * @throws ProveedorUsuariosException Si ocurre un error durante la lectura de usuarios.
   */
  public Map<String, UsuarioPassword> leeUsuario() throws ProveedorUsuariosException {

    try {
      Connection conn = DriverManager.getConnection(database);
      PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario");

      ResultSet resultado = stmt.executeQuery();

      Map<String, UsuarioPassword> salida = new HashMap<>();

      while (resultado.next()) {
        UsuarioPassword usuario = new UsuarioPassword(resultado.getString("nombre"), resultado.getString("password"), resultado.getInt("ID"));
        salida.put(usuario.getNombre(), usuario);
      }
      resultado.close();
      stmt.close();
      conn.close();
      return salida;
    } catch (SQLException e) {
      throw new ProveedorUsuariosException();
    }
  }
}