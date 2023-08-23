package com.example.sns.dto;

import com.example.sns.domain.entity.Following;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
