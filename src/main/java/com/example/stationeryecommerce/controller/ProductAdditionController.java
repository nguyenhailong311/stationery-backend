package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.request.ProductAddition;
import com.example.stationeryecommerce.service.CategoryService;
import com.example.stationeryecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductAdditionController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @GetMapping("/get-categories")
    public ResponseEntity<?> getCategories() {
        List<Category> categories = categoryService.getCategories();
        if (categories != null) return new ResponseEntity<>(categories, HttpStatus.OK);
        else return new ResponseEntity<>("Categories not found!", HttpStatus.NOT_FOUND);
    }
    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody ProductAddition productAddition) {
        Product existedProduct = productService.findProductByName(productAddition.getName());
        if (existedProduct != null) return new ResponseEntity<>("Product existed!", HttpStatus.BAD_REQUEST);
        else {
            Product product = productService.addProduct(productAddition);
            if (product != null) return new ResponseEntity<>("Product added successfully!", HttpStatus.OK);
            else return new ResponseEntity<>("Product added failed!", HttpStatus.BAD_REQUEST);
        }
    }
}
