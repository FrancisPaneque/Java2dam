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
import hlc.ud04.controllAcceso.autenticador.PermisosUsuario;
import hlc.ud04.controllAcceso.autenticador.UsuarioPassword;

public class GestorPermisosSQL {
	
	private String database;

	public GestorPermisosSQL(String database) {
		this.database = database;
	}
	
	public Map<Integer, Integer> leePermisos() {
		
		try {
			Connection conn = DriverManager.getConnection(database);
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM permisosUsuario");
			
			ResultSet resultado = stmt.executeQuery();
			
			Map<Integer, Integer> salida = new HashMap<>();
			
			while (resultado.next()) {
				PermisosUsuario permisoUsuario = new PermisosUsuario(resultado.getInt("ID"), resultado.getInt("permisos"));
				salida.put(permisoUsuario.getID(), permisoUsuario.getPermiso());
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
