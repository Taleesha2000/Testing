package springboot.Testing.pos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Testing.pos.dto.CustomerDTO;
import springboot.Testing.pos.dto.request.CustomerUpdateDTO;
import springboot.Testing.pos.entity.Customer;
import springboot.Testing.pos.exception.NotFoundException;
import springboot.Testing.pos.repo.CustomerRepo;
import springboot.Testing.pos.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerdto) {
//        System.out.println(customerdto.getCustomerAddress());
        Customer customer = new Customer(
                customerdto.getCustomerId(),
                customerdto.getCustomerName(),
                customerdto.getCustomerAddress(),
                customerdto.getCustomerSalary(),
                customerdto.getNic(),
                customerdto.isActive()
        );
        customerRepo.save(customer);
        return customerdto.getCustomerName();
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " updated successfully";

        }else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);

            return new CustomerDTO(
                    customer.getCustomerId(),
                    customer.isActive(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.getCustomerAddress(),
                    customer.getCustomerName()
            );
        }else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomer = customerRepo.findAll();
        if(getAllCustomer.size()>0) {


        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomer) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.isActive(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.getCustomerAddress(),
                    customer.getCustomerName()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
        }else {
            throw new NotFoundException("No customers found");
        }
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return customerId + " deleted successfully";
        }else {
            throw new RuntimeException("Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCostomersActiveState(boolean activeState) {
        List<Customer> getAllCostomersActiveState = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCostomersActiveState) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.isActive(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.getCustomerAddress(),
                    customer.getCustomerName()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }


    @Override
    public String patchCustomer(CustomerUpdateDTO patchDTO) {
        Optional<Customer> optionalCustomer = customerRepo.findById(patchDTO.getCustomerId());

        if (!optionalCustomer.isPresent()) {
            throw new RuntimeException("Customer not found with ID: " + patchDTO.getCustomerId());
        }

        Customer customer = optionalCustomer.get();

        if (patchDTO.getCustomerName() != null && !patchDTO.getCustomerName().isEmpty()) {
            customer.setCustomerName(patchDTO.getCustomerName());
        }

        if (patchDTO.getCustomerAddress() != null && !patchDTO.getCustomerAddress().isEmpty()) {
            customer.setCustomerAddress(patchDTO.getCustomerAddress());
        }

        if (patchDTO.getCustomerSalary() != 0.0) {
            customer.setCustomerSalary(patchDTO.getCustomerSalary());
        }

        customerRepo.save(customer);

        return "Customer with ID " + patchDTO.getCustomerId() + " patched successfully.";
    }
}
