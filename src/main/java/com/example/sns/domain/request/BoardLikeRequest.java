package com.example.sns.domain.request;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.BoardLikeEntity;
import com.example.sns.domain.entity.User;

public record BoardLikeRequest(Long userSeq
        , Long boardSeq) {
    public BoardLikeEntity toEntity() {
        return BoardLikeEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .build();
    }
}
