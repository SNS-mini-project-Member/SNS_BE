package com.example.sns.user.domain.entity;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(unique = true, nullable = false, name = "email")
    private String userEmail;

    @Column(nullable = false, name = "password")
    private String userPassword;

    @Column(nullable = false, name = "name")
    private String userName;

    @Column(nullable = false, name = "age")
    private Integer userAge;

    @Column(unique = true, nullable = false, name = "phone")
    private String userPhone;

    @Column(nullable = false, name = "followers_count")
    private Integer followersCount;

    @Column(nullable = false, name = "followings_count")
    private Integer followingsCount;

    @Column(nullable = true, name = "created_at")
    private Timestamp createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BoardEntity> boards;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntities;

}