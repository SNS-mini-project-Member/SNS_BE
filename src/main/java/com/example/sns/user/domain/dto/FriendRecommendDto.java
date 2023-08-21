package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendRecommend;
import com.example.sns.user.domain.response.FriendRecommendResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
public class FriendRecommendDto {

    private Long friendRecommendId;


    public FriendRecommendDto(FriendRecommend friendRecommend){
        this.friendRecommendId = friendRecommend.getFriendRecommendationsSeq();
    }

    public FriendRecommendDto(){

    }
}
