package com.example.sns.user.domain.request;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor

public class FollowerRequest {

    private final Long userId;

    private final Long followerUserId;


    public Follower toEntity() {
        Follower build = Follower
                .builder()
                .followersSeq(User.builder()
                        .userId(userId)
                        .build().getUserId())
                .followerUserId(followerUserId)
                .userId(userId)
                .build();
        return build;
    }


}
