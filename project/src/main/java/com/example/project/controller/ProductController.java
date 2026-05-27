package com.example.project.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
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
}