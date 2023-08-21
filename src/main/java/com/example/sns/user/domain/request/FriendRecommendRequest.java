package com.example.sns.user.domain.request;

import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.FriendRecommend;
import com.example.sns.user.domain.entity.User;
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
                    .friendRecommendationsSeq(User.builder().userId(friendRecommendId).build().getUserId())
                    .recommendedUserId(friendRecommendId)
                    .userId(userId)
                    .build();
            return build;
        }
}
