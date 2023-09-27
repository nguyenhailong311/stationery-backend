package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.request.CategoryAddition;
import com.example.stationeryecommerce.repository.CategoryRepository;
import com.example.stationeryecommerce.repository.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(CategoryAddition categoryAddition) {
        Category category = new Category();
        category.setName(categoryAddition.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    @Transactional
    public void deleteCategory(Category category) {
        List<Product> products = productRepository.findByCategory(category);
        for (Product product: products) productRepository.delete(product);
        categoryRepository.delete(category);
    }

    @Override
    public Category editCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> searchCategories(String keyword) {
        List<Category> categories = categoryRepository.findAll();
        if (StringUtils.isBlank(keyword)) return categories;
        else return categories.stream().filter(category -> category.getName().toLowerCase().contains(keyword)).collect(Collectors.toList());
    }

}
