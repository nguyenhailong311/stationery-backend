package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductManagementController {
    @Autowired
    private ProductService productService;
    @GetMapping("/get-products")
    public ResponseEntity<?> getProducts() {
        List<Product> products = productService.getProducts();
        if (products != null) return new ResponseEntity<>(products, HttpStatus.OK);
        else return new ResponseEntity<>("Products not found!", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/search-products")
    public ResponseEntity<?> searchProducts(
            @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(name = "category_name", required = false, defaultValue = "") String category_name
        ) {
        List<Product> filteredProducts = productService.searchProducts(keyword, category_name);
        if (filteredProducts.size() > 0) return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
        else return new ResponseEntity<>("No products found!", HttpStatus.NOT_FOUND);
    }
}
