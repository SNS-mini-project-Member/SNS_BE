package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.FollowerDto;
import com.example.sns.user.domain.dto.FriendRecommendDto;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendRecommend;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Builder

public class FriendRecommendResponse extends FriendRecommendDto {

    public FriendRecommendResponse(FriendRecommend friendRecommend) {
        super(friendRecommend);
    }

    public FriendRecommendResponse(){}

}
