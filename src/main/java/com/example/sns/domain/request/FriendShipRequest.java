package com.example.sns.domain.request;

import com.example.sns.domain.entity.FriendShip;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FriendShipRequest {

    private final Long friendShipId;
    private final Long userId;

    public FriendShip toEntity() {
        FriendShip build = FriendShip
                .builder()
                .friendShipSeq(User.builder().userSeq(userId).build().getUserSeq())
                .userId(userId)
                .friendshipsId(friendShipId)
                .build();
        return build;
    }
}

