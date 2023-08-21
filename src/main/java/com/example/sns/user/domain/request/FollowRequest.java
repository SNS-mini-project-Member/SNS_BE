package com.example.sns.user.domain.request;

import lombok.Getter;

@Getter
public class FollowRequest {
    private FollowingRequest followingRequest;
    private FollowerRequest followerRequest;
}
