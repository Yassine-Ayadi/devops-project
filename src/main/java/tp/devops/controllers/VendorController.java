package tp.devops.controllers;

import org.springframework.web.bind.annotation.*;
import tp.devops.entities.Vendor;
import tp.devops.services.VendorService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/vendors")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService){this.vendorService = vendorService;}

    @PostMapping("/create")
    public Vendor createVendor(@RequestBody Vendor createVendorDto) throws IOException {
        return this.vendorService.createVendor(createVendorDto);
    }

    @GetMapping("/all")
    public List<Vendor> getAllVendors() {return  this.vendorService.getAllVendors();}
}
