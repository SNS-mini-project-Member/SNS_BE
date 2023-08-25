package com.example.sns.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @CreationTimestamp
    @Column(name ="create_at", nullable = false)
    private LocalDateTime createAt;

}