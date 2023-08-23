package com.example.sns.domain.response;

import com.example.sns.domain.entity.FriendReq;
import com.example.sns.dto.FriendReqDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FriendReqResponse extends FriendReqDto {


    public FriendReqResponse(FriendReq friendReq) {
        super(friendReq);
    }

    public FriendReqResponse(){

    }
}
