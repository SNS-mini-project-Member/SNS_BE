package com.example.sns.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "FriendShips")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
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
    private Timestamp createAt;

    @PrePersist
    protected void onCreate(){
        createAt = new Timestamp(System.currentTimeMillis());
    }
}
