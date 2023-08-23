package com.example.sns.domain.request;
import com.example.sns.domain.entity.Follower;
import com.example.sns.domain.entity.User;
import lombok.Getter;

@Getter
public class FollowerEmailRequest {

    private Long userId;

    private Long userSeq;

    private Long followerUserId;

    private String email;

    private String name;

    private String age;

    public Follower toEntity() {
        Follower build = Follower
                .builder()
                .followersSeq(User.builder()
                        .userSeq(userSeq)
                        .userEmail(email)
                        .userName(name)
                        .userAge(age)
                        .build().getUserSeq())
                .followerUserId(followerUserId)
                .userId(userId)
                .build();
        return build;
    }
}
