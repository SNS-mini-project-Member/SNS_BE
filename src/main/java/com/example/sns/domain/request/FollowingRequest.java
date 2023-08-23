package com.example.sns.user.domain.request;


import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FollowingRequest {
    private final Long userId;

    private final Long followingId;

    public Following toEntity() {
        Following build = Following
                .builder()
                .followingsSeq(User.builder().userId(followingId).build().getUserId())
                .followingUserId(userId)
                .userId(followingId)
                .build();
        return build;
    }
}
