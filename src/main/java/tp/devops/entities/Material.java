package tp.devops.entities;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Material{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long vendor_id;
    private int stock;
    private String material_type;



    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVendorId() {
        return vendor_id;
    }

    public void setVendorId(Long vendor_id) {
        this.vendor_id = vendor_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMaterialType() {
        return material_type;
    }

    public void setMaterialType(String material_type) {
        this.material_type = material_type;
    }


}
