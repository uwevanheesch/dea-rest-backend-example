package nl.han.dea.persistence;

import nl.han.dea.resource.LoginDTO;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Default
public class AuthenticationDAOImpl implements AuthenticationDAO {

    private ConnectionFactory connectionFactory;

    @Override
    public boolean accountExists(LoginDTO loginDTO) {
        try (
                Connection connection = connectionFactory.getConnection();
        ) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM account where username=? and password=?");
            statement.setString(1, loginDTO.getUser());
            statement.setString(2, loginDTO.getPassword());
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) return true;
            else return false;

        } catch (SQLException e) {
            throw new PersistenceException("Could not connect to database", e);
        }
    }

    public String getUsernameForToken(String token) {
        try (
                Connection connection = connectionFactory.getConnection();
        ) {
            PreparedStatement statement = connection.prepareStatement("SELECT username FROM tokens where token=?");
            statement.setString(1, token);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("username");
            } else throw new TokenNotFoundException();

        } catch (SQLException e) {
            throw new PersistenceException("Could not connect to database", e);
        }
    }

    public void addTokenForUser(String token, String username) {
        try (
                Connection connection = connectionFactory.getConnection();
        ) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tokens(username,token) VALUES(?,?)");
            statement.setString(1, username);
            statement.setString(2, token);
            statement.execute();
        } catch (SQLException e) {
            throw new PersistenceException("Unspecified error occurred.", e);
        }
    }

    @Inject
    public void setConnectionFactory(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
}
