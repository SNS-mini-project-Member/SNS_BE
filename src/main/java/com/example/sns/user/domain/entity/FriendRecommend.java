package com.example.sns.user.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FriendRecommendations")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FriendRecommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendRecommendationsSeq;

    @Column(name="user_id",unique = true, nullable = false)
    private Long userId;

    @Column(name ="recommended_user_id", unique = true, nullable = false)
    private Long recommendedUserId;

    @Column(name ="create_at" , nullable = false)
    private String createAt;

}