package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.request.CategoryAddition;

import java.util.List;

public interface CategoryService {
    public List<Category> getCategories();
    public Category addCategory(CategoryAddition categoryAddition);
    public Category findCategoryByName(String name);
    public void deleteCategory(Category category);
    public Category editCategory(Category category);
    public List<Category> searchCategories(String keyword);
}
