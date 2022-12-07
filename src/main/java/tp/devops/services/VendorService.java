package tp.devops.services;

import org.springframework.stereotype.Service;
import tp.devops.entities.Vendor;
import tp.devops.repositories.VendorRepository;

import java.io.IOException;
import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {this.vendorRepository = vendorRepository;}
    public Vendor createVendor(Vendor vendor) throws IOException{
        try {
            return this.vendorRepository.save(vendor);
        }catch (Exception e){
            throw new IOException("Cannot create ", e);
        }
    }

    public List<Vendor> getAllVendors() { return this.vendorRepository.findAll();}
}
