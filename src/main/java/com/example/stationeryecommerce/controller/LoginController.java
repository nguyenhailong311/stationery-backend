package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.User;
import com.example.stationeryecommerce.entity.request.UserLogin;
import com.example.stationeryecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/log-in-user")
    public ResponseEntity<?> logInUser(@RequestBody UserLogin userLogin) {
        User registeredUser = userService.findUserByEmail(userLogin.getEmail());
        if (registeredUser != null) {
            if (registeredUser.getPassword().equals(userLogin.getPassword())) return new ResponseEntity<>(registeredUser, HttpStatus.OK);
            else return new ResponseEntity<>("User password is wrong!", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>("Email haven't been registered yet!", HttpStatus.NOT_FOUND);
        }
    }
}
