package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.FollowerDto;
import com.example.sns.user.domain.dto.FollowingDto;
import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.Following;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder
public class FollowingResponse extends FollowingDto {


    public FollowingResponse(Following following) {
        super(following);
    }
}
