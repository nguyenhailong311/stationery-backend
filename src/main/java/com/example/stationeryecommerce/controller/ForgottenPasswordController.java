package com.example.stationeryecommerce.controller;

import com.example.stationeryecommerce.entity.model.User;
import com.example.stationeryecommerce.entity.request.UserForgottenPassword;
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
public class ForgottenPasswordController {
    @Autowired
    private UserService userService;
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody UserForgottenPassword userForgottenPassword) {
        User registeredUser = userService.findUserByEmail(userForgottenPassword.getEmail());
        if (registeredUser != null) {
            if (registeredUser.getPassword().equals(userForgottenPassword.getPassword())) return new ResponseEntity<>("The new password must be different with the old password!", HttpStatus.BAD_REQUEST);
            registeredUser.setPassword(userForgottenPassword.getPassword());
            User user = userService.changePassword(registeredUser);
            if (user != null) {
                return new ResponseEntity<>("Password changed successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Password changed failed!", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Email haven't been registered yet!", HttpStatus.NOT_FOUND);
        }
    }
}
