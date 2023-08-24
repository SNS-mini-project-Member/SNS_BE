package com.example.sns.domain.request;

import com.example.sns.domain.entity.Follower;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class FollowerRequest {

    private Long userSeq;

    private final Long userId;

    private final Long followerUserId;

    private final String age;

    private final String userName;
    private final String userEmail;
    private final String userPhone;


    public Follower toEntity() {
        Follower build = Follower
                .builder()
                .followersSeq(User.builder()
                        .userSeq(userSeq)
                        .userAge(age)
                        .userName(userName)
                        .userEmail(userEmail)
                        .userPhone(userPhone)
                        .build().getUserSeq())
                .followerUserId(followerUserId)
                .userId(userId)
                .build();
        return build;
    }


}
