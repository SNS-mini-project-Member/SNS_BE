package com.example.sns.user.domain.response;


import com.example.sns.user.domain.dto.FriendShipDto;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendShip;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder

public class FriendShipResponse extends FriendShipDto {

    public FriendShipResponse(FriendShip friendShip) {
        super(friendShip);
    }
}
