package com.example.sns.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comments")

public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentSeq;

    @ManyToOne
    @JoinColumn(name = "userSeq")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardSeq")
    private BoardEntity board;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<ReCommentEntity> reCommentEntity;

    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY)
    private List<CommentLikeEntity> commentLikeEntities;

    @Column(nullable = false, name = "comment")
    private String comment;

    @Column(nullable = true, name = "created_at")
    private Timestamp createdAt;

    @Column(nullable = false, name = "likeCount", columnDefinition = "INT default 0")
    @Setter
    private Integer likeCount;

    @Column(nullable = false, name = "commentCount", columnDefinition = "INT default 0")
    @Setter
    private Integer commentCount;

    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }



}
