package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.Following;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@Setter
public class FollowingDto {

    private Long followingId;

    public FollowingDto(Following following){
        this.followingId = following.getFollowingsSeq();
    }

    public FollowingDto(){
    }
}
