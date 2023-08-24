package com.example.sns.dto;

import com.example.sns.domain.entity.Follower;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FollowerDto {
    private Long followerId;

    public FollowerDto(Follower follower) {
        this.followerId = follower.getFollowersSeq();
    }

    public FollowerDto() {
    }

}
