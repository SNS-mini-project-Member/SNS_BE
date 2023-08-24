package com.example.sns.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FriendRequest {
    private FriendShipRequest friendShipRequest;
    private FriendRecommendRequest friendRecommendRequest;
    private FriendReqRequest friendReqRequest;
}
