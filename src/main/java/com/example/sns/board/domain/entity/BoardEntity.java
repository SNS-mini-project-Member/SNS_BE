package com.example.sns.board.domain.entity;

import com.example.sns.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Getter @Entity @Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;

    @Column(nullable = false, name = "contents")
    private String contents;

    @Column(nullable = false, name = "media")
    private String media;


    @Column(nullable = false, name = "hash_tag")
    private String hashTag;

    @Column(nullable = true, name = "created_at")
    private Timestamp createdAt;

    @Column(nullable = false, name = "like_count", columnDefinition = "INT default 0")
    private Integer likeCount;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }

    @ManyToOne
    @JoinColumn(name = "userSeq") // 외래키를 userSeq로 지정
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<ReCommentEntity> ReCommentEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<BoardLikeEntity> commentLikeEntities;

    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void decreaseLikeCount() {
        if (likeCount > 0) {
            this.likeCount--;
        }
    }
}