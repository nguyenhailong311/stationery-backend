package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.User;
import com.example.stationeryecommerce.entity.request.UserRegistration;
import com.example.stationeryecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class RegistrationController {
    @Autowired
    private UserService userService;
    @PostMapping("/register-user")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistration userRegistration) {
        User registedUser = userService.findUserByEmail(userRegistration.getEmail());
        if (registedUser != null) {
            return new ResponseEntity<>("Email registered!", HttpStatus.BAD_REQUEST);
        } else {
            User user = userService.registerUser(userRegistration);
            if (user != null) {
                return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User registered failed!", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
