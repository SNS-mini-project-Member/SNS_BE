package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.FriendReqDto;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendReq;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
