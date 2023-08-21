package com.example.sns.user.domain.request;

import lombok.Getter;

@Getter
public class FriendRequest {
    private FriendShipRequest friendShipRequest;
    private FriendRecommendRequest friendRecommendRequest;
    private FriendReqRequest friendReqRequest;
}
