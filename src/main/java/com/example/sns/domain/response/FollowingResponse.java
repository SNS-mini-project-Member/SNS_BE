package com.example.sns.domain.response;

import com.example.sns.domain.entity.Following;
import com.example.sns.dto.FollowingDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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
