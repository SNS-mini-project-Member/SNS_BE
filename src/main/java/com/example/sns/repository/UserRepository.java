package com.example.sns.repository;


import com.example.sns.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.userEmail=:email")
    Optional<User> findByEmail(String email);

    @Query("select u from User u where u.userEmail=:email and u.userPassword=:password")
    Optional<User> findByEmailAndPassword(String email, String password);



}
