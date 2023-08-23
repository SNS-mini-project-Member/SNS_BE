package com.example.sns.user.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name ="create_at", nullable = false)
    private Date createAt;

    @PrePersist
    protected void onCreate(){
        createAt = new Date();
    }

}
