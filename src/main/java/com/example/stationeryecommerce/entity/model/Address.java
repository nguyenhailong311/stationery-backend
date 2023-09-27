package com.example.stationeryecommerce.entity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String province;
    @Column(nullable = false)
    private String city;
    private String detail;
}
