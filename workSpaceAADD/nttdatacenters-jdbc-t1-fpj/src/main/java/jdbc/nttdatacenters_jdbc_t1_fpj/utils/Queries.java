package jdbc.nttdatacenters_jdbc_t1_fpj.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class containing methods to execute SQL queries related to services and employees.
 */
public class Queries {  
		
		//Logger for the Connect class
  	private static final Logger LOG = LoggerFactory.getLogger(Queries.class);
	
		//Private constructor to prevent instantiation
  	private Queries() {
      	throw new AssertionError("Utility class should not be instantiated.");
  	}
  	
    /**
     * Retrieves all services from the database and logs the information.
     *
     * @param connection Database connection.
     */
    public static void retrieveAllServices(Connection connection) {
        try {
            // Query to select all services.
            String query = "SELECT * FROM nttdata_t1mysql_services";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Retrieve information from the result.
                    int id = resultSet.getInt("id_service");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    String technologies = resultSet.getString("tecnologies");
                    boolean isAgile = resultSet.getBoolean("isAgile");

                    // Log information.
                    LOG.info("Service ID: {}", id);
                    LOG.info("Name: {}", name);
                    LOG.info("Description: {}", description);
                    LOG.info("Technologies: {}", technologies);
                    LOG.info("Agile: {}", isAgile);
                    LOG.info("---------------");
                }
            }
        } catch (SQLException e) {
        		LOG.error("Error retrieving services", e);
        }
    }

    /**
     * Retrieves employees associated with a specific service and logs the information.
     *
     * @param connection   Database connection.
     * @param serviceName  Name of the service for which employees will be retrieved.
     */
    public static void retrieveEmployeesForService(Connection connection, String serviceName) {
        try {
            // Query to select employees for a specific service.
            String query = "SELECT * FROM nttdata_t1mysql_employees e " +
                    "JOIN nttdata_t1mysql_services s ON e.id_service = s.id_service " +
                    "WHERE s.name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, serviceName);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Retrieve information from the result.
                        int employeeId = resultSet.getInt("id_employee");
                        String employeeName = resultSet.getString("name");
                        String role = resultSet.getString("rol");

                        // Log information.
                        LOG.info("Employee ID: {}", employeeId);
                        LOG.info("Name: {}", employeeName);
                        LOG.info("Role: {}", role);
                        LOG.info("---------------");
                    }
                }
            }
        } catch (SQLException e) {
        	LOG.error("Error retrieving employees for service: {}", serviceName, e);
        }
    }
}
