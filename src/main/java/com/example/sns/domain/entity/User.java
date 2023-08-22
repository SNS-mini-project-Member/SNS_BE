package com.example.sns.domain.entity;

import com.example.sns.dto.UserLevel;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userSeq;

    @Column(unique = true, nullable = false, name = "email")
    private String userEmail;

    @Column(nullable = false, name = "password")
    private String userPassword;

    @Column(nullable = false, name = "name")
    private String userName;

    @Column(nullable = false, name = "age")
    private String userAge;

    @Column(unique = true, nullable = false, name = "phone")
    private String userPhone;

    @Column(name = "followers_count")
    private Integer followersCount;

    @Column(name = "followings_count")
    private Integer followingsCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_level")
    private UserLevel level;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.followersCount = 0;
        this.followingsCount = 0;
        this.level = UserLevel.LEVEL_OK;
    }




}
