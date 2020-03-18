package nl.han.dea.services;

import nl.han.dea.services.dto.CustomerDTO;

import java.util.List;

/**
 * Created by uwe@vanheesch.net on 18.03.20.
 */
public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
}
