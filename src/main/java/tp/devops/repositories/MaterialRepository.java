package tp.devops.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tp.devops.entities.Material;

public interface MaterialRepository extends JpaRepository<Material,Long> {
}