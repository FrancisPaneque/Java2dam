package hlc.ud04.practica02.parte01.controlacceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;

public class ControlAccesoSqlite implements ControlAcceso {
  
  private static final String SQLITE_JDBC = "jdbc:sqlite:";
  
  private String database;
  
  public ControlAccesoSqlite(String database) {
    this.database = database;
  }

  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      conn = DriverManager.getConnection(SQLITE_JDBC + database);
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT * FROM sec_permisos WHERE uid = " 
        + usuario.getUid());
      if (rs.next()) {
        int lectura = rs.getInt("lectura");
        int escritura = rs.getInt("escritura");
        return ((lectura != 0) && (operacion == Operacion.LECTURA))
          || ((escritura != 0) && (operacion == Operacion.ESCRITURA));
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    } finally {
      // Intenta liberar lo que se esté usando
      try {
        rs.close();
      } catch (Exception e) {}
      try {
        stmt.close();
      } catch (Exception e) {}
      try {
        conn.close();
      } catch (Exception e) {}
    }
  }

}
