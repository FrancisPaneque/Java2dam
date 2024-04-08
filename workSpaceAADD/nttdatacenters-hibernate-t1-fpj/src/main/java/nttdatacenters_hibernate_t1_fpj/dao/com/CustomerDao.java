package nttdatacenters_hibernate_t1_fpj.dao.com;

import java.util.List;
import nttdatacenters_hibernate_t1_fpj.models.com.*;

/**
 * Interface for Customer (Cliente) DAO operations, extending the CommonDaoInt interface.
 */
public interface CustomerDao extends CommonDaoInt<Customer> {

    /**
     * Searches for customers based on names and surnames.
     *
     * @param name           Customer's name.
     * @param firstSurname   Customer's first surname.
     * @param secondSurname  Customer's second surname.
     * @return List of customers matching the provided names and surnames.
     */
    List<Customer> searchCustomersByNameAndSurname(String name, String firstSurname, String secondSurname);

}

