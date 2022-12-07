package tp.devops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.devops.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}