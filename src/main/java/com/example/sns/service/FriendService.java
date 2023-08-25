package com.example.sns.service;

import com.example.sns.domain.entity.FriendRecommend;
import com.example.sns.domain.entity.FriendShip;
import com.example.sns.domain.entity.User;
import com.example.sns.domain.request.FriendRequest;
import com.example.sns.domain.response.UserResponse;
import com.example.sns.repository.FriendRecommendRepository;
import com.example.sns.repository.FriendReqRepository;
import com.example.sns.repository.FriendShipRepository;
import com.example.sns.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendService {

    private final FriendRecommendRepository friendRecommendRepository;
    private final FriendReqRepository friendReqRepository;
    private final FriendShipRepository friendShipRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserResponse> getAllFriends(PageRequest request, Long userId){

        Page<User> allFriend = friendShipRepository.findAllFriend(userId,request);
        return allFriend
                .map(UserResponse::new);

    }

    @Transactional(readOnly = true)
    public UserResponse getFriendByName(String userName){

        UserResponse friend = userRepository.findByName(userName);
        return friend;

    }


    @Transactional(readOnly = true)
    public Page<UserResponse> getAllFriendReq(PageRequest request,Long id){
        Page<User> allFriendReq = friendReqRepository.findAllFriendReq(id,request);
        return allFriendReq
                .map(UserResponse::new);
    }

    @Transactional(readOnly = true)
    public Page<UserResponse> getAllFriendRecommend(PageRequest request, Long userId) {
        List<User> allUsers = userRepository.findAll();
        Page<User> allFriends = friendShipRepository.findAllFriend(userId, request);

        List<Long> friendUserIds = allFriends.stream()
                .map(User::getUserSeq)
                .collect(Collectors.toList());

        List<User> nonFriendUsers = allUsers.stream()
                .filter(user -> !friendUserIds.contains(user.getUserSeq()))
                .collect(Collectors.toList());

        List<User> randomNonFriendUsers = getRandomUsers(nonFriendUsers, 20);

        return new PageImpl<>(randomNonFriendUsers.stream()
                .map(UserResponse::new)
                .collect(Collectors.toList()), request, randomNonFriendUsers.size());
    }

    private List<User> getRandomUsers(List<User> allUsers, int count) {
        List<User> randomUsers = new ArrayList<>();
        Random random = new Random();

        while (randomUsers.size() < count && !allUsers.isEmpty()) {
            int randomIndex = random.nextInt(allUsers.size());
            randomUsers.add(allUsers.remove(randomIndex));
        }

        return randomUsers;
    }

    @Transactional
    public void saveFriends(FriendRequest friendRequest) {
        FriendShip friendShip = friendRequest.getFriendShipRequest().toEntity();
        Long userId1 = friendShip.getUserId();
        Long userId2 = friendShip.getFriendshipsId();

        boolean exists = friendShipRepository.existsByUserIdAndFriendshipsId(userId1, userId2) ||
                friendShipRepository.existsByUserIdAndFriendshipsId(userId2, userId1);

        if (!exists) {
            friendShipRepository.save(friendShip);

            FriendShip reverseFriendShip = new FriendShip();
            reverseFriendShip.setUserId(userId2);
            reverseFriendShip.setFriendshipsId(userId1);
            friendShipRepository.save(reverseFriendShip);

//            friendReqRepository.deleteByReqId(friendRequest.getFriendReqRequest().getFriendReqId());
//            friendRecommendRepository.deleteByRecommendId(friendRequest.getFriendRecommendRequest().getFriendRecommendId());
        } else {
            System.out.println("이미 친구인 계정입니다.");
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
        friendShipRepository.deleteByFriendId(User.builder().userSeq(friendId).build().getUserSeq());
    }

    @Transactional
    public void deleteByRecommendId(Long recommendId){
        friendRecommendRepository.deleteByRecommendId(User.builder().userSeq(recommendId).build().getUserSeq());
    }

    @Transactional
    public void deleteByReqId(Long reqId){
        friendReqRepository.deleteByReqId(User.builder().userSeq(reqId).build().getUserSeq());
    }

}
