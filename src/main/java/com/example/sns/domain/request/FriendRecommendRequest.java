package com.example.sns.domain.request;

import com.example.sns.domain.entity.FriendRecommend;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
    public class FriendRecommendRequest {
        private final Long friendRecommendId;
        private final Long userId;

        public FriendRecommend toEntity() {
            FriendRecommend build = FriendRecommend
                    .builder()
                    .friendRecommendationsSeq(User.builder().userSeq(friendRecommendId).build().getUserSeq())
                    .recommendedUserId(friendRecommendId)
                    .userId(userId)
                    .build();
            return build;
        }
}
