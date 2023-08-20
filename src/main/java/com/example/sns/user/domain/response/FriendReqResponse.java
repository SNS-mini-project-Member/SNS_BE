package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.FriendReqDto;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendReq;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder

public class FriendReqResponse extends FriendReqDto {


    public FriendReqResponse(FriendReq friendReq) {
        super(friendReq);
    }
}
