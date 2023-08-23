package com.example.sns.domain.request;
import com.example.sns.domain.entity.FriendReq;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FriendReqRequest {

    private final Long friendReqId;
    private final Long userId;

    public FriendReq toEntity() {
        FriendReq build = FriendReq
                .builder()
                .friendRequestsSeq(User.builder().userSeq(friendReqId).build().getUserSeq())
                .requesterId(friendReqId)
                .requesteeId(userId)
                .build();
        return build;
    }
}

