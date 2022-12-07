package tp.devops.controllers;

import org.springframework.web.bind.annotation.*;
import tp.devops.entities.Product;
import tp.devops.services.ProductService;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService=productService;
    }

    @PostMapping("/create")
    public Product createProduct (
            @RequestBody Product createProductDto
    ) throws IOException {
        return this.productService.createProduct(createProductDto);
    }



    @GetMapping("/all")
    public List<Product> getAll () {
        return this.productService.getAllProducts();
    }



}
