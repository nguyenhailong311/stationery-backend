package com.example.stationeryecommerce.entity.request;

import lombok.Data;

@Data
public class UserRegistration {
    private String username;
    private String email;
    private String password;
}
