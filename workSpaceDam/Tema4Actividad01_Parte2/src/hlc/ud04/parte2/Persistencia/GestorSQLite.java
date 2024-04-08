package hlc.ud04.parte2.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import hlc.ud04.parte2.models.UsuarioSQlite;

public class GestorSQLite {
	
	private String dataBase;

	public GestorSQLite(String dataBase) {
		this.dataBase = dataBase;
	}
	
	public Map<String, UsuarioSQlite> leeUsuario() {
			
			try {
				Connection conn = DriverManager.getConnection(dataBase);
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario");
				
				ResultSet resultado = stmt.executeQuery();
				
				Map<String, UsuarioSQlite> salida = new HashMap<>();
				
				while (resultado.next()) {
					UsuarioSQlite usuario = new UsuarioSQlite(resultado.getString("nombre"), resultado.getString("secreto"), resultado.getInt("ID"));
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
