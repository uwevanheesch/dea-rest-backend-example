package nl.han.dea.service;

import nl.han.dea.service.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
}
