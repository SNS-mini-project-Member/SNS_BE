package com.example.sns.user.controller;

import com.example.sns.user.domain.request.FriendRecommendRequest;
import com.example.sns.user.domain.request.FriendReqRequest;
import com.example.sns.user.domain.request.FriendShipRequest;
import com.example.sns.user.domain.response.FriendRecommendResponse;
import com.example.sns.user.domain.response.FriendReqResponse;
import com.example.sns.user.domain.response.FriendShipResponse;
import com.example.sns.user.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend")
public class FriendController {


    private final FriendService friendService;

    @GetMapping("/getFriendShip")
    public Page<FriendShipResponse> getAllFriendShip(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        return friendService.getAllFriends(
                PageRequest.of(page,size));
    }

    @GetMapping("/getFriendRecommend")
    public Page<FriendRecommendResponse> getAllFriendRecommend(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        return friendService.getAllFriendRecommend(
                PageRequest.of(page,size));
    }

    @GetMapping("/getFriendReq")
    public Page<FriendShipResponse> getAllFriendReq(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        return friendService.getAllFriendReq(
                PageRequest.of(page,size));
    }

    @PostMapping("/addFriends")
    public void saveFriends(@RequestBody FriendShipRequest request){
        friendService.saveFriends(request);
    }

    @PostMapping("/addFriendRecommend")
    public void saveFriendRecommend(@RequestBody FriendRecommendRequest request){
        friendService.saveFriendRecommend(request);
    }


    @DeleteMapping("/delete/{friendShipId}")
    public void deleteByFriendId(@PathVariable("friendShipId") Long friendId){
        friendService.deleteByFriendId(friendId);
    }

    @DeleteMapping("/delete/{recommendId}")
    public void deleteByRecommendId(@PathVariable("recommendId") Long recommendId){
        friendService.deleteByRecommendId(recommendId);

    }

    @DeleteMapping("/delete/{reqId}")
    public void deleteByReqId(@PathVariable("reqId") Long reqId){
        friendService.deleteByReqId(reqId);

    }

}
