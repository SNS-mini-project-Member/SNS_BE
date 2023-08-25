package com.example.sns.domain.request;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.CommentEntity;
import com.example.sns.domain.entity.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record CommentRequest(Long userSeq
        , Long boardSeq
        , String commentData) {
    public CommentEntity toEntity() {
        return CommentEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .comment(commentData)
                .build();
    }

}

