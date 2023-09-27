package com.example.stationeryecommerce.service;

import com.example.stationeryecommerce.entity.model.User;
import com.example.stationeryecommerce.entity.request.UserRegistration;

public interface UserService {
    public User registerUser(UserRegistration userRegistration);
    public User findUserByEmail(String email);
    public User changePassword(User user);
    public User findUserById(Long id);
}
