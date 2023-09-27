package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.Evaluation;
import com.example.stationeryecommerce.entity.model.Product;
import com.example.stationeryecommerce.entity.model.User;
import com.example.stationeryecommerce.entity.request.CommentSending;
import com.example.stationeryecommerce.repository.EvaluationRepository;
import com.example.stationeryecommerce.repository.ProductRepository;
import com.example.stationeryecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EvaluationServiceImplementation implements EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Evaluation sendEvaluation(CommentSending commentSending) {
        User user = userRepository.findUserById(commentSending.getUser_id());
        if (user == null) return null;
        Product product = productRepository.findProductById(commentSending.getProduct_id());
        if (product == null) return null;
        Evaluation evaluation = new Evaluation();
        evaluation.setComment(commentSending.getComment());
        evaluation.setUser(user);
        evaluation.setRate(commentSending.getStar());
        evaluation.setProduct(product);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        evaluation.setDate(dateFormat.format(date));
        evaluation.setTime(timeFormat.format(date));
        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<Evaluation> findEvaluationsByProductId(Long id) {
        Product product = productRepository.findProductById(id);
        if (product == null) return null;
        return evaluationRepository.findEvaluationsByProduct(product);
    }
}
