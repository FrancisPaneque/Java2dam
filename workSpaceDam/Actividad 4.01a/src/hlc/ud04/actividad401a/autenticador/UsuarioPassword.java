package hlc.ud04.actividad401a.autenticador;

public class UsuarioPassword {

  private String usuario;
  private String password;
  private long id;
  /**
   * @param usuario
   * @param password
   * @param id
   */
  public UsuarioPassword(String usuario, String password, long id) {
    this.usuario = usuario;
    this.password = password;
    this.id = id;
  }
  /**
   * @return the usuario
   */
  public String getUsuario() {
    return usuario;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @return the id
   */
  public long getId() {
    return id;
  }
  
  
}
