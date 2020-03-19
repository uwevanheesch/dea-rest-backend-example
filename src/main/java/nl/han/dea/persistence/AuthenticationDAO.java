package nl.han.dea.persistence;

import nl.han.dea.resource.LoginDTO;

public interface AuthenticationDAO {
    boolean accountExists(LoginDTO loginDTO);

    String getUsernameForToken(String token);

    void addTokenForUser(String token, String username);
}
