package tp.devops.entities;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private Long material_id;
    private String product_name;
    private boolean availability;



    public Long getProductId() {
        return product_id;
    }
    

    public void setProductId(Long id) {
        this.product_id = id;
    }

    public Long getMaterialId() {
        return material_id;
    }

    public void setMaterialId(Long id) {
        this.material_id = id;
    }
    public String getProductName() {
        return product_name;
    }

    public void setProductName(String name) {
        this.product_name = name;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }



}
