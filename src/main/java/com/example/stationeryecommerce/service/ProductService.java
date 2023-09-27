package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.request.ProductAddition;

import java.util.List;

public interface ProductService {
    public List<Product> findProductsByCategory(Category category);
    public Product addProduct(ProductAddition productAddition);
    public Product findProductByName(String name);
    public List<Product> getProducts();
    public void deleteProductById(Long id);
    public Product findProductById(Long id);
    public Product editProduct(Product product);
    List<Product> searchProducts(String keyword, String category_name);
}
