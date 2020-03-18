package nl.han.dea.service;

import nl.han.dea.persistence.CustomerDAO;
import nl.han.dea.service.dto.CustomerDTO;

import javax.inject.Inject;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO customerDAO;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }


    @Inject
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
