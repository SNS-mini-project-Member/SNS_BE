package com.example.sns.user.domain.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @Column(name="user_id",unique = true, nullable = false)
    private Long userId;

    @Column(name ="follower_user_id", unique = true, nullable = false)
    private Long followerUserId;

    @Column(name ="create_at" , nullable = false)
    private Date createAt;
}
