package hlc.ud04.controllAcceso.autenticador;

public class PermisosUsuario {
	
	private int ID;
	private int permiso;
	
	public PermisosUsuario(int id, int permiso) {
		this.ID = id;
		this.permiso = permiso;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the permiso
	 */
	public int getPermiso() {
		return permiso;
	}

}
