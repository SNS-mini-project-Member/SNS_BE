package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import com.example.sns.board.domain.entity.CommentLikeEntity;
import com.example.sns.user.domain.entity.User;

public record CommentLikeRequest(Long userSeq
        , Long boardSeq
        , Long commentSeq) {
    public CommentLikeEntity toEntity(){
        return CommentLikeEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .comment(CommentEntity.builder().commentSeq(commentSeq).build())
                .build();
    }
}
