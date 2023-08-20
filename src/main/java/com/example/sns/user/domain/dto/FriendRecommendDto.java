package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendRecommend;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class FriendRecommendDto extends FriendRecommend {

    private Long friendRecommendId;


    public FriendRecommendDto(FriendRecommend friendRecommend){
        this.friendRecommendId = friendRecommend.getFriendRecommendationsSeq();
    }
}
