package nl.han.dea.persistence;

import nl.han.dea.services.dto.CustomerDTO;

import java.util.List;

public interface CustomerDAO {
    List<CustomerDTO> getAllCustomers();
}
