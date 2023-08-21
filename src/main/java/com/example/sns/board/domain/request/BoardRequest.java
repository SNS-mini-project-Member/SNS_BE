package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.user.domain.entity.User;

import java.sql.Time;
import java.sql.Timestamp;

public record BoardRequest(User user, String contents, String media, String hashTag, Timestamp creatAt) {
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .user(user)
                .contents(contents)
                .media(media)
                .hashTag(hashTag)
                .createdAt(creatAt)
                .build();

    }
}
