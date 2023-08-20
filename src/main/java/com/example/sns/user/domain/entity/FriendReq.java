package com.example.sns.user.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name="requester_id",unique = true, nullable = false)
    private Long requesterId;

    @Column(name ="requestee_id", unique = true, nullable = false)
    private Long requesteeId;

    @Column(name ="create_at" , nullable = false)
    private String createAt;

}
