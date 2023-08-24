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
@Table(name = "FriendReqeusts")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendReq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendRequestsSeq;

    @Column(name="requester_id", nullable = false)
    private Long requesterId;

    @Column(name ="requestee_id", nullable = false)
    private Long requesteeId;

    @CreationTimestamp
    @Column(name ="create_at", nullable = false)
    private LocalDateTime createAt;

}
