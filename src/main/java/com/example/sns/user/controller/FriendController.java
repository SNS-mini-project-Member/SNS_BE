package com.example.sns.user.controller;

import com.example.sns.user.domain.entity.User;
import com.example.sns.user.domain.request.FriendRecommendRequest;
import com.example.sns.user.domain.request.FriendReqRequest;

import com.example.sns.user.domain.request.FriendRequest;
import com.example.sns.user.domain.request.FriendShipRequest;
import com.example.sns.user.domain.response.FriendRecommendResponse;
import com.example.sns.user.domain.response.FriendReqResponse;
import com.example.sns.user.domain.response.FriendShipResponse;
import com.example.sns.user.domain.response.UserResponse;
import com.example.sns.user.service.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend")
@Slf4j
public class FriendController {


    private final FriendService friendService;

    @GetMapping("/friendShip")
    public Page<UserResponse> getFriendShip(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "5") Integer size
    ) {
        Long userId = 11L;
        Page<UserResponse> allFriends = friendService.getAllFriends(PageRequest.of(page, size), userId);
        return allFriends;
    }

    @GetMapping("/getFriendRecommend")
    public Page<UserResponse> getAllFriendRecommend(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        Long userId = 11L;
        Page<UserResponse> allFriendRecommend = friendService.getAllFriendRecommend(PageRequest.of(page, size),userId);
        return allFriendRecommend;
    }

    @GetMapping("/getFriendReq")
    public Page<UserResponse> getAllFriendReq(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        Long userId = 11L;
        Page<UserResponse> allFriendReq = friendService.getAllFriendReq(PageRequest.of(page, size), userId);
        return allFriendReq;
    }

    @PostMapping("/addFriends")
    public void saveFriends(@RequestBody FriendRequest friendRequest){
        friendService.saveFriends(friendRequest);
    }

    @PostMapping("/reqFriends")
    public void reqFriends(@RequestBody FriendRequest friendRequest) {friendService.reqFriends(friendRequest);}

    @PostMapping("/addFriendRecommend")
    public void saveFriendRecommend(@RequestBody FriendRequest friendRequest){
        friendService.saveFriendRecommend(friendRequest);
    }


    @DeleteMapping("/deleteFriend/{friendShipId}")
    public void deleteByFriendId(@PathVariable("friendShipId") Long friendId){
        friendService.deleteByFriendId(friendId);
    }

    @DeleteMapping("/deleteRecommend/{recommendId}")
    public void deleteByRecommendId(@PathVariable("recommendId") Long recommendId){
        friendService.deleteByRecommendId(recommendId);

    }

    @DeleteMapping("/deleteReq/{reqId}")
    public void deleteByReqId(@PathVariable("reqId") Long reqId){
        friendService.deleteByReqId(reqId);
    }

}
