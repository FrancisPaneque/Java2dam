package nttdatacenters_hibernate_t1_fpj.main.com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import nttdatacenters_hibernate_t1_fpj.dao.com.*;
import nttdatacenters_hibernate_t1_fpj.service.com.*;
import nttdatacenters_hibernate_t1_fpj.models.com.*;

public class App {
    public static void main(String[] args) {
        // Hibernate Configuration
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // DAO and Service creation
        CustomerDao customerDao = new CustomerDaoImpl(session);
        CustomerService customerService = new CustomerServiceImpl(session);

        // Example of Service usage
        Customer newCustomer = new Customer();
        newCustomer.setName("John");
        newCustomer.setFirstLastName("Doe");
        newCustomer.setIdNumber("123456789");

        // Add customer
        customerService.addCustomer(newCustomer);

        // Get customer by ID
        Customer retrievedCustomer = customerService.getCustomerById(newCustomer.getId());
        System.out.println("Retrieved customer: " + retrievedCustomer.getName() + " " + retrievedCustomer.getFirstLastName());

        // Search customers by names and last names
        System.out.println("Customers found by names and last names:");
        customerService.searchCustomersByNameAndSurname("John", "Doe", null)
                .forEach(c -> System.out.println(c.getName() + " " + c.getFirstLastName()));

        // Perform other operations as needed

        // Close session and sessionFactory when finished
        session.close();
        sessionFactory.close();
    }
}
