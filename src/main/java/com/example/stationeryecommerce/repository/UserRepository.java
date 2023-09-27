package com.example.stationeryecommerce.repository;

import com.example.stationeryecommerce.entity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findUserById(Long id);
}
