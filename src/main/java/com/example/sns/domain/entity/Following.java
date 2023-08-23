package com.example.sns.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Followings")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followingsSeq;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name ="following_user_id", nullable = false)
    private Long followingUserId;

    @Column(name ="create_at", nullable = false)
    private Date createAt;
    @PrePersist
    protected void onCreate(){
        createAt = new Date();
    }
}