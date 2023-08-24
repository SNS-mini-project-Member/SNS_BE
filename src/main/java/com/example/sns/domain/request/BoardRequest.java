package com.example.sns.domain.request;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.User;

import java.sql.Timestamp;

public record BoardRequest(Long userSeq
        , String contents
        , String media
        , String hashTag
        , Integer likeCount
        , Integer bookMarkCount
        , Integer commentCount
        , Timestamp creatAt) {

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .contents(contents)
                .media(media)
                .hashTag(hashTag)
                .likeCount(0)
                .bookMarkCount(0)
                .commentCount(0)
                .createdAt(creatAt)
                .build();

    }
}
