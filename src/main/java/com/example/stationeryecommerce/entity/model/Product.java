package com.example.stationeryecommerce.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    private String image;
    private double discount_price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private int number_of_views;
    private int number_of_purchases;
    @Column(nullable = false)
    private String creation_date;
    @Column(nullable = false)
    private int quantity;
}
