package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.service.CategoryService;
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
public class CategoryDeletionController {
    @Autowired
    private CategoryService categoryService;
    @DeleteMapping("/delete-category/{name}")
    public ResponseEntity<?> deleteCategory(@PathVariable String name) {
        Category existedCategory = categoryService.findCategoryByName(name);
        if (existedCategory != null) {
            categoryService.deleteCategory(existedCategory);
            return new ResponseEntity<>("Category deleted!", HttpStatus.OK);
        } else return new ResponseEntity<>("Category not found!", HttpStatus.NOT_FOUND);
    }
}
