package com.example.sns.user.domain.dto;
import com.example.sns.user.domain.entity.Follower;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FollowerDto extends Follower {
    private Long followerId;


    public FollowerDto(Follower follower){
        this.followerId = follower.getFollowersSeq();
    }
}
