package com.example.sns.domain.request;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.CommentEntity;
import com.example.sns.domain.entity.User;

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

