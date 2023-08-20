package com.example.sns.user.service;

import com.example.sns.user.domain.entity.*;
import com.example.sns.user.domain.request.FollowerRequest;
import com.example.sns.user.domain.request.FriendRecommendRequest;
import com.example.sns.user.domain.request.FriendShipRequest;
import com.example.sns.user.domain.response.FollowerResponse;
import com.example.sns.user.domain.response.FriendRecommendResponse;
import com.example.sns.user.domain.response.FriendReqResponse;
import com.example.sns.user.domain.response.FriendShipResponse;
import com.example.sns.user.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendService {

    private final FriendRecommendRepository friendRecommendRepository;
    private final FriendReqRepository friendReqRepository;
    private final FriendShipRepository friendShipRepository;

    @Transactional(readOnly = true)
    public Page<FriendShipResponse> getAllFriends(PageRequest request){
        Page<FriendShip> allFriend = friendShipRepository.findAll(request);
        return allFriend
                .map(FriendShipResponse::new);
    }

    @Transactional(readOnly = true)
    public Page<FriendShipResponse> getAllFriendReq(PageRequest request){
        Page<FriendShip> allFriendReq = friendReqRepository.findAll(request);
        return allFriendReq
                .map(FriendShipResponse::new);
    }

    @Transactional(readOnly = true)
    public Page<FriendRecommendResponse> getAllFriendRecommend(PageRequest request){
        Page<FriendRecommend> allFriendRecommend = friendRecommendRepository.findAll(request);
        return allFriendRecommend
                .map(FriendRecommendResponse::new);
    }

    @Transactional
    public void saveFriends(FriendShipRequest friendShipRequest) {

        Optional<FriendShip> byCheck = friendShipRepository.findByCheck(friendShipRequest.getFriendShipId());
        if (byCheck.isEmpty()){
            friendShipRepository.save(friendShipRequest.toEntity());
            friendReqRepository.save(friendShipRequest.toEntity());
        }else {
            //이미 친구인 계정입니다.
        }

    }

    @Transactional
    public void saveFriendRecommend(FriendRecommendRequest friendRecommendRequest) {

        Optional<FriendRecommend> byCheck = friendRecommendRepository.findByCheck(friendRecommendRequest.getFriendRecommendId());
        if (byCheck.isEmpty()){
            friendRecommendRepository.save(friendRecommendRequest.toEntity());
        }else {
        }

    }


    @Transactional
    public void deleteByFriendId(Long friendId){
        friendShipRepository.deleteByFriendId(User.builder().userId(friendId).build().getUserId());
    }

    @Transactional
    public void deleteByRecommendId(Long recommendId){
        friendRecommendRepository.deleteByRecommendId(User.builder().userId(recommendId).build().getUserId());
    }

    @Transactional
    public void deleteByReqId(Long reqId){
        friendReqRepository.deleteByReqId(User.builder().userId(reqId).build().getUserId());
    }

}
