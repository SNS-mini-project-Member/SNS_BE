package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.FriendRecommend;
import com.example.sns.user.domain.entity.FriendReq;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class FriendReqDto extends FriendReq {

    private Long friendReqId;

    public FriendReqDto(FriendReq friendReq){
        this.friendReqId = friendReq.getFriendRequestsSeq();
    }
}
