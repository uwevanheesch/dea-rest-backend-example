package nl.han.dea.persistence;

import nl.han.dea.service.dto.CustomerDTO;

import java.util.List;

public interface CustomerDAO {
    List<CustomerDTO> getAllCustomers();
}
