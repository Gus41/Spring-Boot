package com.example.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.models.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    
}
