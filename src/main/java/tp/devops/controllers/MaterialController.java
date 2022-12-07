package tp.devops.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tp.devops.entities.Material;
import tp.devops.services.MaterialService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/materials" )
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService=materialService;
    }

    @PostMapping("/create")
    public Material createMaterial (
            @RequestBody Material createMaterialDto
    ) throws IOException {
        return this.materialService.createMaterial(createMaterialDto);
    }

    @GetMapping("/all")
    public List<Material> getAllMaterials () {
        return this.materialService.getAllMaterials();
    }



}
