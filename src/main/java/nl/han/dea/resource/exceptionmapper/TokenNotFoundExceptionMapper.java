package nl.han.dea.resource.exceptionmapper;

import nl.han.dea.persistence.TokenNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TokenNotFoundExceptionMapper implements ExceptionMapper<TokenNotFoundException> {

    @Override
    public Response toResponse(TokenNotFoundException e) {
        return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid token").build();
    }
}
