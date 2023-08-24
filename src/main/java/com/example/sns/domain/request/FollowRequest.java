package com.example.sns.domain.request;

import com.example.sns.domain.request.FollowingRequest;
import lombok.Getter;

@Getter
public class FollowRequest {
    private FollowingRequest followingRequest;
    private FollowerRequest followerRequest;

    public FollowRequest(FollowingRequest followingRequest, FollowerRequest followerRequest) {
        this.followingRequest = followingRequest;
        this.followerRequest = followerRequest;

    }
}
