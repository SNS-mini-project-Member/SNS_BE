package com.example.sns.user.domain.request;
import com.example.sns.user.domain.entity.FriendRecommend;
import com.example.sns.user.domain.entity.FriendReq;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FriendReqRequest {

    private final Long friendReqId;

    public FriendReq toEntity() {
        FriendReq build = FriendReq
                .builder()
                .friendRequestsSeq(User.builder().userId(friendReqId).build().getUserId())
                .build();
        return build;
    }
}

