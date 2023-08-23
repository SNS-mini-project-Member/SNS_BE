package com.example.sns.domain.response;

import com.example.sns.domain.entity.Follower;
import com.example.sns.dto.FollowerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FollowerResponse extends FollowerDto {
    private Long id;
    public FollowerResponse(Follower follower) {
        super(follower);
    }

    public FollowerResponse(){

    }

}
