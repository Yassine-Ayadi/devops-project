package tp.devops.services;

import org.springframework.stereotype.Service;
import tp.devops.entities.Customer;
import tp.devops.repositories.CustomerRepository;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) throws IOException {
        try{
            return this.customerRepository.save(customer);
        }catch (Exception e){
            throw new IOException("Cannot create this customer");
        }
    }

    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

}