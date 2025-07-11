package springboot.Testing.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.Testing.pos.dto.CustomerDTO;
import springboot.Testing.pos.dto.request.CustomerUpdateDTO;
import springboot.Testing.pos.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin()
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping(path = "/save")
    public String Customersave(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping(path = "/update")
    public String Customerupdate(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @PatchMapping(
            path = "/patch-customer/{id}"
    )
    public String patchCustomer(@PathVariable("id") int id, @RequestBody CustomerUpdateDTO patchDTO) {
        patchDTO.setCustomerId(id); // Ensure ID is set
        return customerService.patchCustomer(patchDTO);
    }


    @GetMapping(
            path = "get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam("id") int customerId) {
        // Assuming you have a method in CustomerService to get customer by ID
        CustomerDTO customerDTO= customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(
            path = "/get-all-costomers"
    )
    public List<CustomerDTO> getAllCostomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path = "/delete-customer/{id}"
    )
    public String deleteCustomer(@RequestParam("id") int customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping(
            path = "/get-all-costomers-by-active-status"
    )
    public List<CustomerDTO> getAllCostomersActiveState(@RequestParam(value = "active") boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCostomersActiveState(activeState);
        return allCustomers;
    }

}