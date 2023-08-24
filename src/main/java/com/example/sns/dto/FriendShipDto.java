package com.example.sns.dto;

import com.example.sns.domain.entity.FriendShip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
