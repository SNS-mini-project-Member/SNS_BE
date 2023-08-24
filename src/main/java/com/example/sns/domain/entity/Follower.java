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
@Table(name = "Followers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "followers_seq", sequenceName = "followers_seq", allocationSize = 1)
    private Long followersSeq;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name ="follower_user_id", nullable = false)
    private Long followerUserId;

    @CreationTimestamp
    @Column(name ="create_at" , nullable = false)
        private LocalDateTime createAt;

}
