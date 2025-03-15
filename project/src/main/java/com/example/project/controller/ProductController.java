package com.example.project.controller;
import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public  ProductController(ProductRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        System.out.println("Product: " + product);
        product.setId(UUID.randomUUID().toString()); //setting id

        this.repository.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id){
        return this.repository.findById(id).orElse(null);
    }

    @GetMapping
    public List<Product> get(){
        return this.repository.findAll();
    }
}
