package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.request.CategoryEdition;
import com.example.stationeryecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class CategoryEditionController {
    @Autowired
    private CategoryService categoryService;
    @PutMapping("/edit-category/{name}")
    public ResponseEntity<?> editCategory(@PathVariable String name, @RequestBody CategoryEdition categoryEdition) {
        Category existedCategory = categoryService.findCategoryByName(name);
        if (existedCategory != null) {
            existedCategory.setName(categoryEdition.getName());
            Category category = categoryService.editCategory(existedCategory);
            if (category != null) return new ResponseEntity<>("Category edited successfully!", HttpStatus.OK);
            else return new ResponseEntity<>("Category edited failed!", HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>("Category not found!", HttpStatus.NOT_FOUND);
    }
}
