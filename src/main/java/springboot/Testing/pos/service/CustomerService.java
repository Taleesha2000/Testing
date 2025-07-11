package springboot.Testing.pos.service;

import springboot.Testing.pos.dto.CustomerDTO;
import springboot.Testing.pos.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerdto);

    String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCostomersActiveState(boolean activeState);

    String patchCustomer(CustomerUpdateDTO patchDTO);
}
