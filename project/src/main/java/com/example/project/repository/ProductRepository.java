package com.example.project.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.project.models.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    
    List<Product> findByName(String name);
}
