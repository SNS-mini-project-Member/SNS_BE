package com.example.sns.user.domain.response;
import com.example.sns.user.domain.dto.FollowerDto;
import com.example.sns.user.domain.entity.Follower;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@Builder

public class FollowerResponse extends FollowerDto{


    public FollowerResponse(Follower follower) {
        super(follower);
    }
}
