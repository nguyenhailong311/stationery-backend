package com.example.stationeryecommerce.entity.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private String avatar;
    private String mobile;
    private boolean gender;
    private String dob;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Column(nullable = false)
    private String role;
}
