package nttdatacenters_hibernate_t1_fpj.service.com;


import nttdatacenters_hibernate_t1_fpj.dao.com.CommonDaoImpl;
import nttdatacenters_hibernate_t1_fpj.models.com.Customer;

import org.hibernate.Session;
import nttdatacenters_hibernate_t1_fpj.dao.com.*;

import java.util.List;

/**
 * Implementation of the Customer Service operations.
 */
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    /**
     * Constructor of the class.
     *
     * @param session Database session.
     */
    public CustomerServiceImpl(Session session) {
        this.customerDao = new CustomerDaoImpl(session);
    }

    /**
     * Adds a customer to the system.
     *
     * @param customer Customer object to be added.
     */
    @Override
    public void addCustomer(Customer customer) {
        customerDao.insert(customer);
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id ID of the customer to be retrieved.
     * @return The customer associated with the provided ID.
     */
    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.getCustomerById(id);
    }

    /**
     * Retrieves all customers from the system.
     *
     * @return List of all customers in the system.
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    /**
     * Deletes a customer from the system based on their ID.
     *
     * @param id ID of the customer to be deleted.
     */
    @Override
    public void deleteCustomer(Long id) {
        customerDao.delete(id);
    }

    /**
     * Updates customer information in the system.
     *
     * @param customer Customer object with updated information.
     */
    @Override
    public void updateCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }

    /**
     * Searches for customers based on names and surnames.
     *
     * @param name            Customer's name.
     * @param firstSurname    Customer's first surname.
     * @param secondSurname   Customer's second surname.
     * @return List of customers matching the provided names and surnames.
     */
    @Override
    public List<Customer> searchCustomersByNameAndSurname(String name, String firstSurname, String secondSurname) {
        return customerDao.searchCustomersByNameAndSurname(name, firstSurname, secondSurname);
    }

}
