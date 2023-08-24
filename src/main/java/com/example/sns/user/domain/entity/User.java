package com.example.sns.user.domain.entity;

import com.example.sns.board.domain.entity.*;
import com.example.sns.board.store.UserBoard;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Entity @Builder
@Getter @AllArgsConstructor
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ReCommentEntity> ReCommentEntities;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private List<BoardLikeEntity> boardLikeEntities;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CommentLikeEntity> commentLikeEntities;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserBoard> userBoards;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntities;
}