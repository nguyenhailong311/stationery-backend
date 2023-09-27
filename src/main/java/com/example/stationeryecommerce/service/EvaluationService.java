package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.Evaluation;
import com.example.stationeryecommerce.entity.request.CommentSending;

import java.util.List;

public interface EvaluationService {
    public Evaluation sendEvaluation(CommentSending commentSending);
    public List<Evaluation> findEvaluationsByProductId(Long id);
}
