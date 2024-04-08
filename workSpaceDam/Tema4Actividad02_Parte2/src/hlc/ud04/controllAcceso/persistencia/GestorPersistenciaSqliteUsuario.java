package hlc.ud04.controllAcceso.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import hlc.ud04.appsec.core.Cliente;
import hlc.ud04.appsec.core.GestorPersistencia;
import hlc.ud04.appsec.persistencia.GestorPersistenciaSqlite;
import hlc.ud04.controllAcceso.autenticador.UsuarioPassword;

public class GestorPersistenciaSqliteUsuario {
	
	private String database;

	public GestorPersistenciaSqliteUsuario(String database) {
		this.database = database;
	}
	
	public Map<String, UsuarioPassword> leeUsuario() {
		
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
