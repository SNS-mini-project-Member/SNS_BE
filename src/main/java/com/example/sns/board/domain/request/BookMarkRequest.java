package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BookmarkEntity;
import com.example.sns.user.domain.entity.User;

public record BookMarkRequest(Long boardSeq
        , Long userSeq) {
    public BookmarkEntity toEntity(){
        return BookmarkEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .build();
    }
}
