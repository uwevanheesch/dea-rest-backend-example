package nl.han.dea.services;

import nl.han.dea.persistence.CustomerDAO;
import nl.han.dea.services.dto.CustomerDTO;

import javax.inject.Inject;
import java.util.List;

public class CustomerService {

    private CustomerDAO customerDAO;

    public List<CustomerDTO> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    @Inject
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
