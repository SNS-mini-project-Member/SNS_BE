package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.FriendRecommend;
import com.example.sns.user.domain.entity.FriendReq;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
public class FriendReqDto {

    private Long friendReqId;

    public FriendReqDto(FriendReq friendReq){
        this.friendReqId = friendReq.getFriendRequestsSeq();
    }

    public FriendReqDto(){

    }
}
