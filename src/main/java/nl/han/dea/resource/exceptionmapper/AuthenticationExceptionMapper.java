package nl.han.dea.resource.exceptionmapper;

import nl.han.dea.service.AuthenticationFailedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationFailedException> {

    @Override
    public Response toResponse(AuthenticationFailedException e) {
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
