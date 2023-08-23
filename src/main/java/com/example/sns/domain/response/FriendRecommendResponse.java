package com.example.sns.domain.response;
import com.example.sns.domain.entity.FriendRecommend;
import com.example.sns.dto.FriendRecommendDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class FriendRecommendResponse extends FriendRecommendDto {

    public FriendRecommendResponse(FriendRecommend friendRecommend) {
        super(friendRecommend);
    }

    public FriendRecommendResponse(){}

}
