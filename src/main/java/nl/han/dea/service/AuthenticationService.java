package nl.han.dea.service;

import nl.han.dea.resource.LoginDTO;
import nl.han.dea.resource.TokenDTO;

public interface AuthenticationService {
    TokenDTO authenticate(LoginDTO loginDTO);

    String getUsernameForToken(String token);
}
