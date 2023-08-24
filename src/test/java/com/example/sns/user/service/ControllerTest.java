package com.example.sns.user.service;
import com.example.sns.domain.request.*;
import com.example.sns.service.FollowService;
import com.example.sns.service.FriendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {


    @Autowired
    private FriendService friendService;
    @Autowired
    private FollowService followService;



    @Test
    public void testFollowRequests() {

        Long followerId = 11L;
        Long[] followerUserIds = {2L, 11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L, 21L};


        for (Long followingId : followerUserIds) {
            String age = generateRandomAge();
            String userName = generateRandomUserName();
            String userEmail = generateRandomEmail();
            String userPhone = generateRandomPhoneNumber();
            FollowerRequest followerRequest = new FollowerRequest(followerId, followingId, age, userName, userEmail, userPhone);
            FollowingRequest followingRequest = new FollowingRequest(followingId, followerId);
            FollowRequest followRequest = new FollowRequest(followingRequest, followerRequest);
            followService.saveFollower(followRequest);
        }
    }


        private String generateRandomAge() {
            Random random = new Random();
            int age = random.nextInt(50) + 20; // Assuming age between 20 and 70
            return String.valueOf(age);
        }

        private String generateRandomUserName() {
            String[] names = {"Alice", "Bob", "Charlie", "David", "Emma", "Fiona", "George", "Hannah", "Isaac", "Julia"};
            Random random = new Random();
            int index = random.nextInt(names.length);
            return names[index];
        }

        private String generateRandomEmail() {
            String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
            Random random = new Random();
            int index = random.nextInt(domains.length);
            return "user" + System.currentTimeMillis() + "@" + domains[index];
        }

        private String generateRandomPhoneNumber() {
            StringBuilder phoneNumber = new StringBuilder("+1");
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                phoneNumber.append(random.nextInt(10));
            }
            return phoneNumber.toString();
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