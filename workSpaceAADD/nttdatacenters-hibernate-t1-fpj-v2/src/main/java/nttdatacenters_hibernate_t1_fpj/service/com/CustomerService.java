package nttdatacenters_hibernate_t1_fpj.service.com;

import nttdatacenters_hibernate_t1_fpj.models.com.*;
import java.util.List;

/**
 * Service interface for Customer (Cliente) operations.
 */
public interface CustomerService {

    /**
     * Adds a customer to the system.
     *
     * @param customer Customer object to be added.
     */
    void addCustomer(Customer customer);

    /**
     * Retrieves a customer by their ID.
     *
     * @param id ID of the customer to be retrieved.
     * @return The customer associated with the provided ID.
     */
    Customer getCustomerById(Long id);

    /**
     * Retrieves all customers from the system.
     *
     * @return List of all customers in the system.
     */
    List<Customer> getAllCustomers();

    /**
     * Deletes a customer from the system based on their ID.
     *
     * @param id ID of the customer to be deleted.
     */
    void deleteCustomer(Long id);

    /**
     * Updates customer information in the system.
     *
     * @param customer Customer object with updated information.
     */
    void updateCustomer(Customer customer);

    /**
     * Searches for customers based on names and surnames.
     *
     * @param name            Customer's name.
     * @param firstSurname    Customer's first surname.
     * @param secondSurname   Customer's second surname.
     * @return List of customers matching the provided names and surnames.
     */
    List<Customer> searchCustomersByNameAndSurname(String name, String firstSurname, String secondSurname);
}