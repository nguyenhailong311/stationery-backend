package com.example.stationeryecommerce.entity.request;

import com.example.stationeryecommerce.entity.model.Category;
import lombok.Data;

@Data
public class ProductAddition {
    private String name;
    private double price;
    private double discount_price;
    private String category_name;
    private int quantity;
    private String image;
}
