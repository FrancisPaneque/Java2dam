package jdbc.nttdatacenters_jdbc_t1_fpj.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class responsible for establishing a connection to the MySQL database.
 */
public final class Connect {

    private static final Logger logger = LoggerFactory.getLogger(Connect.class);
    private static final Properties properties = loadProperties();

    // Private constructor to prevent instantiation
    private Connect() {
        throw new AssertionError("Utility class should not be instantiated.");
    }

    /**
     * Method that creates a connection to the MySQL database.
     *
     * @return A Connection object representing the database connection.
     */
    public static Connection connect() {
        Connection connection = null;

        try {
            // Retrieve database connection details from properties
            String url = properties.getProperty("DB_URL");
            String database = properties.getProperty("DB_NAME");
            String parameters = properties.getProperty("DB_PARAMETERS");
            String user = properties.getProperty("DB_USER");
            String password = properties.getProperty("DB_PASSWORD");

            // Establish the database connection using the retrieved details
            connection = DriverManager.getConnection(url + database + parameters, user, password);
            logger.info("Connection established successfully.");
        } catch (SQLException e) {
            // Handle connection errors.
            logger.error("Error in database connection.", e);
        }
        return connection;
    }

    /**
     * Loads database properties from the "database.properties" file.
     *
     * @return Properties object containing the loaded database properties.
     */
    private static Properties loadProperties() {
        // Create a Properties object to store database properties.
        Properties props = new Properties();
        try {
            // Load the database properties from the "database.properties" file.
            try (InputStream input = Connect.class.getClassLoader().getResourceAsStream("database.properties")) {
                props.load(input);
            }
        } catch (Exception e) {
            // Log an error if there is an issue loading the properties.
            logger.error("Error loading database properties.", e);
        }
        // Return the loaded properties.
        return props;
    }
}
