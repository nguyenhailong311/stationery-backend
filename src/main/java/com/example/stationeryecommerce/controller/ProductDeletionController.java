package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductDeletionController {
    @Autowired
    private ProductService productService;
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        Product existedProduct = productService.findProductById(id);
        if (existedProduct != null) {
            productService.deleteProductById(id);
            return new ResponseEntity<>("Product deleted!", HttpStatus.OK);
        } else return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }
}
