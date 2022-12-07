package tp.devops.services;

import org.springframework.stereotype.Service;
import tp.devops.entities.Product;
import tp.devops.repositories.ProductRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) throws IOException {
        try{
            return this.productRepository.save(product);
        }catch (Exception e){
            throw new IOException("Cannot create this product");
        }
    }


    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

}