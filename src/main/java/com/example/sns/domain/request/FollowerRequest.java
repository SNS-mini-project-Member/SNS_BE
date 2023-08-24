package com.example.sns.domain.request;

import com.example.sns.domain.entity.Follower;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class FollowerRequest {


    private final Long userId;

    private final Long followerUserId;

    public Follower toEntity() {
        Follower build = Follower
                .builder()
                .followersSeq((User.builder().userSeq(userId)).build().getUserSeq())
                .followerUserId(followerUserId)
                .userId(userId)
                .build();
        return build;
    }


}
