package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.request.ProductEdition;
import com.example.stationeryecommerce.service.CategoryService;
import com.example.stationeryecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductEditionController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @PutMapping("/edit-product/{id}")
    public ResponseEntity<?> editProduct(@PathVariable Long id, @RequestBody ProductEdition productEdition) {
        Product existedProduct = productService.findProductById(id);
        if (existedProduct == null) return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        else {
            existedProduct.setName(productEdition.getName());
            existedProduct.setPrice(productEdition.getPrice());
            existedProduct.setQuantity(productEdition.getQuantity());
            existedProduct.setImage(productEdition.getImage());
            existedProduct.setDiscount_price(productEdition.getDiscount_price());
            Category category = categoryService.findCategoryByName(productEdition.getCategory_name());
            existedProduct.setCategory(category);
            Product product = productService.editProduct(existedProduct);
            if (product != null) return new ResponseEntity<>("Product edited successfully!", HttpStatus.OK);
            else return new ResponseEntity<>("Product edited failed!", HttpStatus.BAD_REQUEST);
        }
    }
}
