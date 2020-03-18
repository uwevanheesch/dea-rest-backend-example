package nl.han.dea.persistence;

import javax.enterprise.inject.Default;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Default
class MySQLConnectionFactory implements ConnectionFactory {

    // Note: file is in src/main/resources
    private static final String PROPERTY_LOCATION = "/dea-database.properties";

    @Override
    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        var properties = loadProperties();

        return DriverManager.getConnection(properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password"));
    }

    private Properties loadProperties() {
        Properties properties = new Properties();
        try (
                InputStream inputStream = this.getClass().getResourceAsStream(PROPERTY_LOCATION);
        ) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new PersistenceException("Properties file could not be read", e);
        }
        return properties;
    }


}
