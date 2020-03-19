package nl.han.dea.resource;

import nl.han.dea.service.AuthenticationService;
import nl.han.dea.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    private CustomerService customerService;
    private AuthenticationService authenticationService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(@QueryParam("token") String token) {
        System.out.println("Authenticated user: " + authenticationService.getUsernameForToken(token));
        return Response.ok(customerService.getAllCustomers()).build();
    }

    @Inject
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Inject
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
