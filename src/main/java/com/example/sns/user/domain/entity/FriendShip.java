package com.example.sns.user.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FriendShips")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendShipSeq;

    @Column(name="user_id",unique = true, nullable = false)
    private Long userId;

    @Column(name ="friendships_id", unique = true, nullable = false)
    private Long friendshipsId;

    @Column(name ="create_at" , nullable = false)
    private String createAt;
}
