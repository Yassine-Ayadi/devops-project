package tp.devops.services;

import org.springframework.stereotype.Service;
import tp.devops.entities.Material;
import tp.devops.repositories.MaterialRepository;

import java.io.IOException;
import java.util.List;


@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public Material createMaterial(Material material) throws IOException {
        try{
            return this.materialRepository.save(material);
        }catch (Exception e){
            throw new IOException("Cannot create this material");
        }
    }

    public List<Material> getAllMaterials() {
        return this.materialRepository.findAll();
    }

}