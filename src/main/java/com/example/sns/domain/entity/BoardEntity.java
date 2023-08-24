package com.example.sns.domain.entity;

import com.example.sns.board.store.UserBoard;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.Instant;
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

    @Column(nullable = false, name = "media")
    private String media;


    @Column(nullable = false, name = "hash_tag")
    private String hashTag;

    @CreationTimestamp
    @Column(nullable = true, name = "created_at")
    private LocalDateTime createdAt;

    @Setter
    @Column(nullable = false, name = "like_count", columnDefinition = "INT default 0")
    private Integer likeCount;

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
