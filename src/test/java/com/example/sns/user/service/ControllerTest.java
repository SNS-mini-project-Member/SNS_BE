package com.example.sns.user.service;
import com.example.sns.user.domain.request.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {


    @Autowired
    private FriendService friendService;
    @Autowired
    private FollowService followService;



    @Test
    public void testFollowRequests() {

        Long followerId = 11L;
        Long[] followingIds = {2L, 11L, 12L, 13L,14L,15L,16L,17L,18L,19L,20L,21L};

        for (Long followingId : followingIds) {
            FollowerRequest followerRequest = new FollowerRequest(followerId, followingId);
            FollowingRequest followingRequest = new FollowingRequest(followingId,followerId);
            FollowRequest followRequest = new FollowRequest(followingRequest,followerRequest);

            followService.saveFollower(followRequest);
        }

    }


    @Test
    public void testFriendRequests() {

        Long userId = 11L;
        Long[] friendIds = {2L, 11L, 12L, 13L,14L,15L,16L,17L,18L,19L,20L,21L};

        for (Long friendId : friendIds) {
            FriendReqRequest friendReqRequest = new FriendReqRequest(friendId, userId);
            FriendShipRequest friendShipRequest = new FriendShipRequest(friendId, userId);
            FriendRecommendRequest friendRecommendRequest = new FriendRecommendRequest(friendId, userId);
            FriendRequest friendRequest = new FriendRequest(friendShipRequest,friendRecommendRequest,friendReqRequest);

            friendService.saveFriends(friendRequest);
        }


    }

    @Test
    public void testRecommendRequest() {


        }






}