package com.example.stationeryecommerce.repository;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
    public Product findByName(String name);
    public Product findProductById(Long id);
}
