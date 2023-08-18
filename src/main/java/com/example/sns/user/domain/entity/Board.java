package com.example.sns.user.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false)
    private String userEmail;
    private String userPassword;
    private String userName;
    private Integer userAge;
}
