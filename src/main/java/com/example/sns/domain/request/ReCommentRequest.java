package com.example.sns.domain.request;

import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.CommentEntity;
import com.example.sns.domain.entity.ReCommentEntity;
import com.example.sns.domain.entity.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record ReCommentRequest (Long userSeq
        , Long boardSeq
        , Long commentSeq
        , String reComment
        , LocalDateTime createAt){
    public ReCommentEntity toEntity() {
        return ReCommentEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .comment(CommentEntity.builder().commentSeq(commentSeq).build())
                .reComment(reComment)
                .createdAt(createAt)
                .build();

    }
}
