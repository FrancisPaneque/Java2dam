package nttdatacenters_hibernate_t1_fpj.dao.com;

import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import nttdatacenters_hibernate_t1_fpj.models.com.Customer;
import nttdatacenters_hibernate_t1_fpj.hibernateUtil.com.*;
import java.util.List;

/**
 * Implementation of the Customer (Cliente) DAO operations.
 */
public class CustomerDaoImpl extends CommonDaoImpl<Customer> implements CustomerDao {

	/**
     * Constructor of the class.
     *
     * @param session Database session.
     */
    public CustomerDaoImpl(Session session) {
        super(session);
    }

    /**
     * Searches for customers based on names and surnames.
     *
     * @param nombre           Customer's name.
     * @param primerApellido   Customer's first surname.
     * @param segundoApellido  Customer's second surname.
     * @return List of customers matching the provided names and surnames.
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<Customer> searchCustomersByNameAndSurname(String name, String firstSurname, String secondSurname) {
        if (!HibernateUtil.getSession().getTransaction().getStatus().equals(TransactionStatus.ACTIVE)) {
        	HibernateUtil.getSession().getTransaction().begin();
        }

        String query = "FROM Cliente WHERE name = :name AND firstSurname = :firstSurname AND secondSurname = :secondSurname";
        return HibernateUtil.getSession()
                .createQuery(query)
                .setParameter("name", name)
                .setParameter("firstSurname", firstSurname)
                .setParameter("secondSurname", secondSurname)
                .list();
    }

}
