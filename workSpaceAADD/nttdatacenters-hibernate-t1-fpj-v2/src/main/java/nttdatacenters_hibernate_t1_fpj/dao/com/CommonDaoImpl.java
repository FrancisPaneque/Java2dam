package nttdatacenters_hibernate_t1_fpj.dao.com;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

/**
 * Generic DAO class, CommonDaoImpl.
 * 
 * @param <T> Type of the entity associated with the DAO.
 */
public abstract class CommonDaoImpl<T> implements CommonDaoInt<T> {

    /** Entity class type */
    private Class<T> entityClass;

    /** Database connection session */
    private Session session;

    /**
     * Constructor of the class.
     * 
     * @param session Database session.
     */
    @SuppressWarnings("unchecked")
    protected CommonDaoImpl(Session session) {
        setEntityClass(
                (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        this.session = session;
    }

    /**
     * Insert method, which inserts an object into the database.
     */
    public void insert(final T paramT) {
        if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().begin();
        }

        session.save(paramT);
        session.flush();
        session.getTransaction().commit();
    }

    /**
     * Method that modifies an object in the database.
     */
    public void update(final T paramT) {
        if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().begin();
        }

        session.saveOrUpdate(paramT);
        session.getTransaction().commit();
    }

    /**
     * Method that deletes an object from the database.
     */
    public void delete(final T paramT) {
        if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().begin();
        }

        session.delete(paramT);
        session.getTransaction().commit();
    }

    /**
     * Method that lists all objects from the database.
     *
     * @return List of all objects in the database.
     */
    @SuppressWarnings("unchecked")
    public List<T> searchAll() {
        if (!session.getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
            session.getTransaction().begin();
        }

        // Returns all objects
        return session.createQuery("FROM " + this.entityClass.getName()).list();
    }

    /**
     * @return the entityClass
     */
    public Class<T> getEntityClass() {
        return entityClass;
    }

    /**
     * @param entityClass the entityClass to set
     */
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}
