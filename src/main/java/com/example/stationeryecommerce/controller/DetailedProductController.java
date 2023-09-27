package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.Category;
import com.example.stationeryecommerce.entity.model.Evaluation;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.request.CommentSending;
import com.example.stationeryecommerce.service.EvaluationService;
import com.example.stationeryecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DetailedProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private EvaluationService evaluationService;
    @GetMapping("/get-product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        if (product != null) return new ResponseEntity<>(product, HttpStatus.OK);
        else return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
    }
    @GetMapping("/get-related-products/{id}")
    public ResponseEntity<?> getRelatedProducts(@PathVariable Long id) {
        Product product = productService.findProductById(id);
        Category category = product.getCategory();
        if (category == null) return new ResponseEntity<>("Category not found!", HttpStatus.NOT_FOUND);
        else {
            List<Product> relatedProducts = productService.findProductsByCategory(category);
            if (relatedProducts.size() > 0) return new ResponseEntity<>(relatedProducts, HttpStatus.OK);
            else return new ResponseEntity<>("Products not found!", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/send-comment")
    public ResponseEntity<?> sendComment(@RequestBody CommentSending commentSending) {
        Evaluation evaluation = evaluationService.sendEvaluation(commentSending);
        if (evaluation != null) return new ResponseEntity<>("Comment sent successfully!", HttpStatus.OK);
        else return new ResponseEntity<>("Comment sent failed!", HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/get-evaluations-by-product/{id}")
    public ResponseEntity<?> getEvaluationsByProduct(@PathVariable Long id) {
        List<Evaluation> evaluations = evaluationService.findEvaluationsByProductId(id);
        if (evaluations.size() > 0) return new ResponseEntity<>(evaluations, HttpStatus.OK);
        else return new ResponseEntity<>("Evaluations not found!", HttpStatus.NOT_FOUND);
    }
}
