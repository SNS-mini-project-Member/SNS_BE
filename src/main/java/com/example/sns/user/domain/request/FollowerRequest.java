package com.example.sns.user.domain.request;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FollowerRequest {

    private final Long followerId;

    public Follower toEntity() {
        Follower build = Follower
                .builder()
                .followersSeq(User.builder().userId(followerId).build().getUserId())
                .build();
        return build;
    }
}
