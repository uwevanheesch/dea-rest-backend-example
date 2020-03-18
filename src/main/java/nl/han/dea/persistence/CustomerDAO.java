package nl.han.dea.persistence;

import nl.han.dea.services.dto.CustomerDTO;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Default
public class CustomerDAO {

    private MySQLConnectionFactory mySQLConnectionFactory;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        try (
                Connection connection = mySQLConnectionFactory.getConnection();
        ) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customerDTOS.add(new CustomerDTO(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            throw new PersistenceException("Could not connect to database", e);
        }
        return customerDTOS;
    }

    @Inject
    public void setMySQLConnectionFactory(MySQLConnectionFactory mySQLConnectionFactory) {
        this.mySQLConnectionFactory = mySQLConnectionFactory;
    }
}
