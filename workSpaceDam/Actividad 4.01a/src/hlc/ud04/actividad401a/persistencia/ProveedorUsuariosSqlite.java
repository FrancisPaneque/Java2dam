package hlc.ud04.actividad401a.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import hlc.ud04.actividad401a.autenticador.UsuarioPassword;

public class ProveedorUsuariosSqlite {

  private String url;
  
  public ProveedorUsuariosSqlite(String url) {
    this.url = url;
  }
  
  public Map<String, UsuarioPassword> leeUsuarios() {
    
    try {
      Connection conn = DriverManager.getConnection(url);
      
      PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario");
      
      ResultSet resultado = stmt.executeQuery();
      
      Map<String, UsuarioPassword> salida = new HashMap<>();
      
      while (resultado.next()) {
        UsuarioPassword usuario = new UsuarioPassword(resultado.getString("usuario")
          , resultado.getString("password"), resultado.getLong("id"));
        salida.put(usuario.getUsuario(), usuario);
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
