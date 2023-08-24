package com.example.sns.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Column(name="user_id", nullable = false)
    private Long userId;

    @Column(name ="friendships_id", nullable = false)
    private Long friendshipsId;

    @CreationTimestamp
    @Column(name ="create_at" , nullable = false)
    private LocalDateTime createAt;

}
