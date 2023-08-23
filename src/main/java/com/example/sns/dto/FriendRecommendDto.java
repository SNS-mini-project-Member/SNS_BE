package com.example.sns.dto;

import com.example.sns.domain.entity.FriendRecommend;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
