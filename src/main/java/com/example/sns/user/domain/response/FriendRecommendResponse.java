package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.FollowerDto;
import com.example.sns.user.domain.dto.FriendRecommendDto;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendRecommend;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public class FriendRecommendResponse extends FriendRecommendDto {

    public FriendRecommendResponse(FriendRecommend friendRecommend) {
        super(friendRecommend);
    }

}
