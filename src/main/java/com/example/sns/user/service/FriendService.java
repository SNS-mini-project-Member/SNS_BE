package com.example.sns.user.service;

import com.example.sns.user.domain.entity.*;
import com.example.sns.user.domain.request.FollowerRequest;
import com.example.sns.user.domain.request.FriendRecommendRequest;

import com.example.sns.user.domain.request.FriendRequest;
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
    public Page<FriendReqResponse> getAllFriendReq(PageRequest request){
        Page<FriendReq> allFriendReq = friendReqRepository.findAll(request);
        return allFriendReq
                .map(FriendReqResponse::new);
    }

    @Transactional(readOnly = true)
    public Page<FriendRecommendResponse> getAllFriendRecommend(PageRequest request){
        Page<FriendRecommend> allFriendRecommend = friendRecommendRepository.findAll(request);
        return allFriendRecommend
                .map(FriendRecommendResponse::new);
    }

    @Transactional
    public void saveFriends(FriendRequest friendRequest) {

        Optional<FriendShip> byCheck = friendShipRepository.findByCheck(friendRequest.getFriendShipRequest().getFriendShipId());
        if (byCheck.isEmpty()){
            friendShipRepository.save(friendRequest.getFriendShipRequest().toEntity());
            friendReqRepository.deleteByReqId(friendRequest.getFriendReqRequest().getFriendReqId());
            friendRecommendRepository.deleteByRecommendId(friendRequest.getFriendRecommendRequest().getFriendRecommendId());
        }else {
            //이미 친구인 계정입니다.
        }

    }

    @Transactional
    public void reqFriends(FriendRequest friendRequest) {
        Optional<FriendShip> byCheck = friendShipRepository.findByCheck(friendRequest.getFriendShipRequest().getFriendShipId());
        Optional<FriendRequest> byCheck2 = friendReqRepository.findByCheck(friendRequest.getFriendReqRequest().getFriendReqId());

        if (byCheck.isEmpty() && byCheck2.isEmpty()){
            friendReqRepository.save(friendRequest.getFriendReqRequest().toEntity());
        }else {
            System.out.println("이미 친구신청을 했거나 친구인 계정입니다.");
        }

    }

    @Transactional
    public void saveFriendRecommend(FriendRequest friendRequest) {

        Optional<FriendRecommend> byCheck = friendRecommendRepository.findByCheck(friendRequest.getFriendRecommendRequest().getFriendRecommendId());
        if (byCheck.isEmpty()){
            friendRecommendRepository.save(friendRequest.getFriendRecommendRequest().toEntity());
        }else {
            System.out.println("친구추천 오류");
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
