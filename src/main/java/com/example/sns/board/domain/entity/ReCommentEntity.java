package com.example.sns.board.domain.entity;

import com.example.sns.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ReCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ReCommentSeq;

    @Column(nullable = false, name = "reComment")
    private String reComment;

    @Column(nullable = true, name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "userSeq")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardSeq")
    private BoardEntity board;

    @ManyToOne
    @JoinColumn(name = "commentSeq")
    private CommentEntity comment;
}
