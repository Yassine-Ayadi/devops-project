package tp.devops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.devops.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
}
