package com.example.sns.board.domain.entity;

import com.example.sns.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

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

    @ManyToOne
    @JoinColumn(name = "parentCommentSeq")
    private CommentEntity parentComment;

    @Column(nullable = false, name = "comment")
    private String comment;

    @Column(nullable = true, name = "created_at")
    private Timestamp createdAt;

    @Column(nullable = false, name = "likeCount", columnDefinition = "INT default 0")
    private Boolean likeCount;
    @PrePersist
    public void prePersist() {
        this.createdAt = Timestamp.from(Instant.now());
    }


}
