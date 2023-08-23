package com.example.sns.user.domain.request;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;

@Getter
public class FollowerEmailRequest {

    private Long userId;

    private Long followerUserId;

    private String email;

    private String name;

    private Integer age;

    public Follower toEntity() {
        Follower build = Follower
                .builder()
                .followersSeq(User.builder()
                        .userId(userId)
                        .userEmail(email)
                        .userName(name)
                        .userAge(age)
                        .build().getUserId())
                .followerUserId(followerUserId)
                .userId(userId)
                .build();
        return build;
    }
}
