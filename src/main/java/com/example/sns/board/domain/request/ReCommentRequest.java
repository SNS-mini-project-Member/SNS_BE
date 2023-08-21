package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import com.example.sns.board.domain.entity.ReCommentEntity;
import com.example.sns.user.domain.entity.User;

import java.sql.Timestamp;

public record ReCommentRequest (Long userSeq
        , Long boardSeq
        , Long commentSeq
        , String reComment
        , Timestamp createAt){
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
