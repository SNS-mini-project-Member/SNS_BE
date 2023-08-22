package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BoardLikeEntity;
import com.example.sns.user.domain.entity.User;

public record BoardLikeRequest(Long userSeq
        , Long boardSeq) {
    public BoardLikeEntity toEntity() {
        return BoardLikeEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .build();
    }
}
