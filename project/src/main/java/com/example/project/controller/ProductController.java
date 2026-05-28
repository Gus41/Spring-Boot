package com.example.project.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.models.Product;

import com.example.project.repository.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        String uuid = UUID.randomUUID().toString();
        product.setId(uuid);
        this.productRepository.save(product);
        return product;
    }

    @GetMapping("/{id}")
     public Product findById(@PathVariable("id") String id){
        //Optional<Product> product = this.productRepository.findById(id);
        //return product.isPresent() ? product.get() : null;
        return this.productRepository.findById(id).orElse(null);
        
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        this.productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Product product){
        product.setId(id);
        this.productRepository.save(product);
    }

    @GetMapping
    public List<Product> search(@RequestParam("name") String name){
        return this.productRepository.findByName(name);
    }

}