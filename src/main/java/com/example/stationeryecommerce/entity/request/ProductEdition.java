package com.example.stationeryecommerce.entity.request;

import lombok.Data;

@Data
public class ProductEdition {
    private String name;
    private double price;
    private double discount_price;
    private String category_name;
    private int quantity;
    private String image;
}
