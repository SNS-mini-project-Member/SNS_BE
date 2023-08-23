package com.example.sns.domain.request;
import com.example.sns.domain.entity.Following;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FollowingRequest {
    private final Long userId;

    private final Long followingId;

    public Following toEntity() {
        Following build = Following
                .builder()
                .followingsSeq(User.builder().userSeq(followingId).build().getUserSeq())
                .followingUserId(userId)
                .userId(followingId)
                .build();
        return build;
    }
}
