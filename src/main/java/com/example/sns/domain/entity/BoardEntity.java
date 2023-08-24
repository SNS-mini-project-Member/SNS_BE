package com.example.sns.domain.entity;

import com.example.sns.board.store.UserBoard;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name = "media")
    private String media;


    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Setter
    @Column(name = "like_count", columnDefinition = "INT default 0")
    private Integer likeCount;

    @Setter
    @Column(name = "board_count", columnDefinition = "INT default 0")
    private Integer bookMarkCount;

    @Setter
    @Column(name = "comment_count", columnDefinition = "INT default 0")
    private Integer commentCount;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.likeCount = 0;
        this.bookMarkCount = 0;
        this.commentCount = 0;
    }

    @ManyToOne
    @JoinColumn(name = "userSeq") // 외래키를 userSeq로 지정
    private User user;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<ReCommentEntity> ReCommentEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<BoardLikeEntity> boardLikeEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<CommentLikeEntity> commentLikeEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<BookmarkEntity> bookmarkEntities;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<UserBoard> userBoards;

}
