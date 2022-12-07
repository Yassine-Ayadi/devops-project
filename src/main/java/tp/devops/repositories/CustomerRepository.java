package tp.devops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.devops.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}