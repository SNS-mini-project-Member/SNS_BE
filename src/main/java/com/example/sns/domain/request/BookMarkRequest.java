package com.example.sns.domain.request;

import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.BookmarkEntity;
import com.example.sns.domain.entity.User;

public record BookMarkRequest(Long boardSeq
        , Long userSeq) {
    public BookmarkEntity toEntity(){
        return BookmarkEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .build();
    }
}
