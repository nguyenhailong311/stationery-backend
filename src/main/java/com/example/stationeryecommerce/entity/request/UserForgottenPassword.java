package com.example.stationeryecommerce.entity.request;

import lombok.Data;

@Data
public class UserForgottenPassword {
    private String email;
    private String password;
}
