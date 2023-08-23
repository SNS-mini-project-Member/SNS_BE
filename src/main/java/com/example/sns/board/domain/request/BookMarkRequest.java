package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BookmarkEntity;

public record BookMarkRequest(Long boardSeq) {
    public BookmarkEntity toEntity(){
        return BookmarkEntity.builder()
                .board(BoardEntity.builder()
                        .boardSeq(boardSeq).build()).build();
    }

}
