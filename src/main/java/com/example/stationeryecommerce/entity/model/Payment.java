package com.example.stationeryecommerce.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payment_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(nullable = false)
    private String payment_method;
    @Column(nullable = false)
    private String bank;
    @Column(nullable = false)
    private String bank_code;
    @Column(nullable = false)
    private String bank_username;
}
