package com.example.sns.user.domain.response;


import com.example.sns.user.domain.dto.FriendShipDto;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendShip;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder
public class FriendShipResponse extends FriendShipDto {

    public FriendShipResponse(FriendShip friendShip) {
        super(friendShip);
    }

    public FriendShipResponse(){
        super();
    }
}
