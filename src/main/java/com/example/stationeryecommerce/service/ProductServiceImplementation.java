package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Evaluation;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.request.ProductAddition;
import com.example.stationeryecommerce.repository.CategoryRepository;
import com.example.stationeryecommerce.repository.EvaluationRepository;
import com.example.stationeryecommerce.repository.ProductRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Override
    public List<Product> findProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product addProduct(ProductAddition productAddition) {
        Product product = new Product();
        product.setName(productAddition.getName());
        Category category = categoryRepository.findByName(productAddition.getCategory_name());
        if (category == null) return null;
        product.setCategory(category);
        product.setImage(productAddition.getImage());
        product.setPrice(productAddition.getPrice());
        product.setQuantity(productAddition.getQuantity());
        product.setDiscount_price(productAddition.getDiscount_price());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        product.setCreation_date(simpleDateFormat.format(date));
        product.setNumber_of_purchases(0);
        product.setNumber_of_views(0);
        return productRepository.save(product);
    }

    @Override
    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteProductById(Long id) {
        Product product = productRepository.findProductById(id);
        List<Evaluation> evaluations = evaluationRepository.findEvaluationsByProduct(product);
        for (Evaluation evaluation: evaluations) {
            evaluationRepository.delete(evaluation);
        }
        productRepository.deleteById(id);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product editProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> searchProducts(String keyword, String category_name) {
        List<Product> products = productRepository.findAll();
        if (StringUtils.isBlank(keyword) && StringUtils.isBlank(category_name)) return products;
        else if (!StringUtils.isBlank(keyword) && StringUtils.isBlank(category_name)) return products.stream().filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase().trim())).collect(Collectors.toList());
        else if (StringUtils.isBlank(keyword) && !StringUtils.isBlank(category_name)) return products.stream().filter(product -> product.getCategory().getName().equalsIgnoreCase(category_name.trim())).collect(Collectors.toList());
        else return products.stream()
                    .filter(product -> product.getName().toLowerCase().contains(keyword.toLowerCase().trim()))
                    .filter(product -> product.getCategory().getName().equalsIgnoreCase(category_name.trim()))
                    .collect(Collectors.toList());
    }
}
