package com.example.sns.user.service;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.Following;
import com.example.sns.user.domain.entity.User;
import com.example.sns.user.domain.request.FollowerRequest;
import com.example.sns.user.domain.request.FollowingRequest;
import com.example.sns.user.domain.response.FollowerResponse;
import com.example.sns.user.domain.response.FollowingResponse;
import com.example.sns.user.repository.FollowerRepository;
import com.example.sns.user.repository.FollowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FollowService {

    private final FollowingRepository followingRepository;
    private final FollowerRepository followerRepository;

    @Transactional(readOnly = true)
    public Page<FollowerResponse> getAllFollower(PageRequest request){
        Page<Follower> allFollower = followerRepository.findAll(request);
        return allFollower
                .map(FollowerResponse::new);
    }

    @Transactional
    public void saveFollower(FollowerRequest followerRequest, FollowingRequest followingRequest) {

        Optional<Follower> byCheck = followerRepository.findByCheck(followerRequest.getFollowerUserId());
        if (byCheck.isEmpty()){
            followerRepository.save(followerRequest.toEntity());
            followingRepository.save(followingRequest.toEntity());
        }else {
            //이미 팔로우된 계정입니다.
        }

    }

    @Transactional
    public void deleteByFollowerUserId(Long followerId){
        followerRepository.deleteByFollowerUserId(User.builder().userId(followerId).build().getUserId());
        followingRepository.deleteByFollowerUserId(User.builder().userId(followerId).build().getUserId());
    }


}
