package com.example.sns.domain.response;
import com.example.sns.domain.entity.FriendShip;
import com.example.sns.dto.FriendShipDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
