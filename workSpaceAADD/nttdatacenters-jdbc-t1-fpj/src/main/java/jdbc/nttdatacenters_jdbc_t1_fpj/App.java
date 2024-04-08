package jdbc.nttdatacenters_jdbc_t1_fpj;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.nttdatacenters_jdbc_t1_fpj.connection.Connect;
import jdbc.nttdatacenters_jdbc_t1_fpj.utils.Queries;

/**
 * 
 * @author Francisco Jose Paneque Jurado
 * 
 * Main application class to demonstrate JDBC functionality.
 */
public class App {
    public static void main(String[] args) throws SQLException {
    	
        Connection connection = null;

        try {
            // Get a database connection
            connection = Connect.connect();

            // Query 1: Retrieve all services
            Queries.retrieveAllServices(connection);

            // Query 2: Retrieve employees for a specific service
            String serviceName = "Naturgy";
            Queries.retrieveEmployeesForService(connection, serviceName);

        } finally {
            // Close the connection in the finally block
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

