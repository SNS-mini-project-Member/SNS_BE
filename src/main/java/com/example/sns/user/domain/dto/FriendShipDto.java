package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.FriendShip;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class FriendShipDto extends FriendShip {
    private Long friendId;
    @Builder
    public FriendShipDto(FriendShip friendShip){
        this.friendId = friendShip.getFriendShipSeq();
    }
}
