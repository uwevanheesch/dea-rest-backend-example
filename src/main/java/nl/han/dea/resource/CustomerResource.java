package nl.han.dea.resource;

import nl.han.dea.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customer")
public class CustomerResource {

    private CustomerService customerService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        return Response.ok(customerService.getAllCustomers()).build();
    }

    @Inject
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
}
