package nl.han.dea.service;

import nl.han.dea.persistence.AuthenticationDAO;
import nl.han.dea.resource.LoginDTO;
import nl.han.dea.resource.TokenDTO;

import javax.inject.Inject;
import java.util.UUID;

public class AuthenticationService {

    private AuthenticationDAO authenticationDAO;

    public TokenDTO authenticate(LoginDTO loginDTO) {
        if (authenticationDAO.accountExists(loginDTO)) {

            String token = UUID.randomUUID().toString();
            authenticationDAO.addTokenForUser(token, loginDTO.getUser());
            return new TokenDTO(loginDTO.getUser(), token);
        } else {
            throw new AuthenticationFailedException();
        }
    }

    public String getUsernameForToken(String token) {
        return authenticationDAO.getUsernameForToken(token);
    }

    @Inject
    public void setAuthenticationDAO(AuthenticationDAO authenticationDAO) {
        this.authenticationDAO = authenticationDAO;
    }
}
