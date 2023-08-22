package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import com.example.sns.user.domain.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.sql.Timestamp;

public record CommentRequest(Long userSeq
        , Long boardSeq
        , String comment
        , Integer likeCount
        , Timestamp createAt) {

    public CommentEntity toEntity() {
        return CommentEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .comment(comment)
                .likeCount(0)
                .createdAt(createAt)
                .build();
    }

}

