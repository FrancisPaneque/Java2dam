package dao;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import models.Usuario;

public class UsuarioDaoImpl extends CommonDaoImpl<Usuario> implements UsuarioDaoInt {

	private Session session;
	
	public UsuarioDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	public void insertUsuario(Usuario user) {
		super.insert(user);
	}
	
	public void updateUsuario(Usuario user) {
		super.update(user);
	}
	
	@Override
	public Usuario getUsuarioByName(String name) {
		if (!session.getTransaction().equals(TransactionStatus.ACTIVE)) {
			session.getTransaction().begin();
		}

		return (Usuario) session.createQuery("FROM Usuario WHERE nombre_usuario='" + name + "'").uniqueResult();
	}
	
	@Override
	public boolean existByName(String name) {
		try {
			session.createQuery("FROM Usuario WHERE nombre_usuario = '" + name + "'").uniqueResult();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
