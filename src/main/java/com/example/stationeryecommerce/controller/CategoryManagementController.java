package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CategoryManagementController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/search-categories")
    public ResponseEntity<?> searchCategories(@RequestParam(name = "keyword", required = false, defaultValue = "") String keyword) {
        List<Category> filteredCategories = categoryService.searchCategories(keyword);
        if (filteredCategories.size() > 0) return new ResponseEntity<>(filteredCategories, HttpStatus.OK);
        else return new ResponseEntity<>("No categories found!", HttpStatus.NOT_FOUND);
    }
}
