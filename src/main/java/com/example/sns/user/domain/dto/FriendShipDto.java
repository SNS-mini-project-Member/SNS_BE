package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.FriendShip;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
public class FriendShipDto {
    private Long friendId;

    public FriendShipDto(FriendShip friendShip){
        this.friendId = friendShip.getFriendShipSeq();
    }

    public FriendShipDto(){

    }
}
