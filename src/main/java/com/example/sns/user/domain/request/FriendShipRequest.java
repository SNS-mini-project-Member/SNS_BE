package com.example.sns.user.domain.request;

import com.example.sns.user.domain.entity.FriendRecommend;
import com.example.sns.user.domain.entity.FriendShip;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FriendShipRequest {

    private final Long friendShipId;

    public FriendShip toEntity() {
        FriendShip build = FriendShip
                .builder()
                .friendShipSeq(User.builder().userId(friendShipId).build().getUserId())
                .build();
        return build;
    }
}

