package com.example.sns.dto;

import com.example.sns.domain.entity.FriendReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
