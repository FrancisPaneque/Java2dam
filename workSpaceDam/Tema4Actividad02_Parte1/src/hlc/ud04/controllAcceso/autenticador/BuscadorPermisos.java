package hlc.ud04.controllAcceso.autenticador;

import java.util.Map;
import hlc.ud04.controllAcceso.persistencia.GestorPermisosSQL;

/**
 * La funcion de esta clase es unicamente devolver el permiso 
 * de un usuario por su ID
 * @author Alvaro
 *
 */
public class BuscadorPermisos {
	
	Map<Integer, Integer> listaPermisos;
	
	public BuscadorPermisos() {
		 GestorPermisosSQL proveedor = new GestorPermisosSQL("jdbc:sqlite:db/base.db");
		 listaPermisos = proveedor.leePermisos();
	}

	public Integer buscaPorId(int id) {
		return listaPermisos.get(id);
	}
}
