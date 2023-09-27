package com.example.stationeryecommerce.repository;

import com.example.stationeryecommerce.entity.model.Evaluation;
import com.example.stationeryecommerce.entity.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    public List<Evaluation> findEvaluationsByProduct(Product product);
}
