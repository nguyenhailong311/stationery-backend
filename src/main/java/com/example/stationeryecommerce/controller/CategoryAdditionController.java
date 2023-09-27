package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.request.CategoryAddition;
import com.example.stationeryecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class CategoryAdditionController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add-category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryAddition categoryAddition) {
        Category existedCategory = categoryService.findCategoryByName(categoryAddition.getName());
        if (existedCategory != null) return new ResponseEntity<>("Category existed!", HttpStatus.BAD_REQUEST);
        else {
            Category category = categoryService.addCategory(categoryAddition);
            if (category != null) return new ResponseEntity<>("Category added successfully!", HttpStatus.OK);
            else return new ResponseEntity<>("Category added failed!", HttpStatus.BAD_REQUEST);
        }
    }
}
