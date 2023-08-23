package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.FollowerDto;
import com.example.sns.user.domain.dto.FollowingDto;
import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.Following;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@Builder
public class FollowingResponse extends FollowingDto {

    private Long id;
    public FollowingResponse(Following following) {
        super(following);
    }

    public FollowingResponse(){

    }
}
