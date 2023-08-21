package com.example.sns.user.domain.dto;
import com.example.sns.user.domain.entity.Follower;
import lombok.*;

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
