package com.example.sns.service;

import com.example.sns.domain.entity.Follower;
import com.example.sns.domain.entity.FriendShip;
import com.example.sns.domain.entity.User;
import com.example.sns.domain.request.FollowRequest;
import com.example.sns.domain.response.GetAllFollowerResponse;
import com.example.sns.repository.FollowerRepository;
import com.example.sns.repository.FollowingRepository;
import com.example.sns.repository.FriendShipRepository;
import com.example.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowService {

    private final FollowingRepository followingRepository;
    private final FollowerRepository followerRepository;
    private final FriendShipRepository friendShipRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<GetAllFollowerResponse> getAllFollowers(PageRequest request, Long followerId) {

        Page<Follower> allFollowers = followerRepository.findFollowerBy(followerId, request);
        Page<FriendShip> allFriends = friendShipRepository.findFriendBy(followerId, request);

        Map<Long, FriendShip> friendShipMap = allFriends.stream()
                .collect(Collectors.toMap(FriendShip::getFriendshipsId, Function.identity()));

        List<GetAllFollowerResponse> followerResponses = allFollowers.stream()
                .map(follower -> {
                    boolean isFriend = friendShipMap.containsKey(follower.getFollowerUserId());
                    Date createAt = follower.getCreateAt();

                    User userInfo = getUserInfo(follower.getUserId());

                    return new GetAllFollowerResponse(
                            userInfo,
                            follower,
                            isFriend,
                            createAt
                    );
                })
                .collect(Collectors.toList());

        return new PageImpl<>(followerResponses, request, allFollowers.getTotalElements());
    }

    private User getUserInfo(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }


    @Transactional
    public void saveFollower(FollowRequest followRequest) {
        Long followerUserId = followRequest.getFollowerRequest().getFollowerUserId();
        Long followingId = followRequest.getFollowingRequest().getFollowingId();

        boolean exists = followerRepository.existsByFollowerUserIdAndUserId(followerUserId, followingId) ||
                followerRepository.existsByFollowerUserIdAndUserId(followingId, followerUserId);

        if (!exists) {
            followerRepository.save(followRequest.getFollowerRequest().toEntity());
            followingRepository.save(followRequest.getFollowingRequest().toEntity());
        } else {

        }
    }




    @Transactional
    public void deleteByFollowerUserId(Long followerId){
        followerRepository.deleteByFollowerUserId(User.builder().userSeq(followerId).build().getUserSeq());
        followingRepository.deleteByFollowerUserId(User.builder().userSeq(followerId).build().getUserSeq());
    }


}
