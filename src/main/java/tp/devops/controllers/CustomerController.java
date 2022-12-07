package tp.devops.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tp.devops.entities.Customer;
import tp.devops.services.CustomerService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customers" )
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService=customerService;
    }

    @PostMapping("/create")
    public Customer createCustomer (
            @RequestBody Customer createCustomerDto
    ) throws IOException {
        return this.customerService.createCustomer(createCustomerDto);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers () {
        return this.customerService.getAllCustomers();
    }



}
