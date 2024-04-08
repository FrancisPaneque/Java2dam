package nttdatacenters_hibernate_t1_fpj.dao.com;

import java.util.List;

/**
 * Interface for common DAO operations.
 *
 * @param <T> Type of the entity associated with the DAO.
 */
public interface CommonDaoInt<T> {

    /**
     * Inserts an object into the database.
     *
     * @param paramT Object to be inserted into the database.
     */
    public void insert(final T paramT);

    /**
     * Updates an object in the database.
     *
     * @param paramT Object to be updated.
     */
    public void update(final T paramT);

    /**
     * Deletes an object from the database.
     *
     * @param paramT Object from the database to be deleted.
     */
    public void delete(final T paramT);

    /**
     * Retrieves all objects from the database.
     *
     * @return List<T> List containing all objects from the database.
     */
    public List<T> searchAll();
}

