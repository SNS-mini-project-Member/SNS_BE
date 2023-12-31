package com.example.sns.repository;


import com.example.sns.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // 회원가입시 이메일 중복체크
    @Query("select u from User u where u.userEmail=:email")
    Optional<User> findByEmail(String email);

    // 로그인
    @Query("select u from User u where u.userEmail=:email and u.userPassword=:password")
    Optional<User> findByEmailAndPassword(String email, String password);

    // 비밀번호 변경 (임시비밀번호를 받고 난 뒤 수정)
    @Query("update User u set u.userPassword=:password where u.userEmail=:email")
    Optional<User> updatePasswordByUserEmail(String email, String password);



}
