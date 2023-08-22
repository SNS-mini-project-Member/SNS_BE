package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.user.domain.entity.User;

import java.sql.Timestamp;

public record BoardRequest(Long userSeq
        , String contents
        , String media
        , String hashTag
        , Integer likeCount
        , Timestamp creatAt) {
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .contents(contents)
                .media(media)
                .hashTag(hashTag)
                .likeCount(0)
                .createdAt(creatAt)
                .build();

    }
}
