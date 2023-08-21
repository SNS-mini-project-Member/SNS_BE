package com.example.sns.user.controller;

import com.example.sns.user.domain.request.FollowRequest;
import com.example.sns.user.domain.request.FollowerRequest;
import com.example.sns.user.domain.request.FollowingRequest;
import com.example.sns.user.domain.response.FollowerResponse;
import com.example.sns.user.domain.response.FollowingResponse;
import com.example.sns.user.service.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow")
@Slf4j
public class FollowController {

    private final FollowService followService;

    @GetMapping
    public Page<FollowerResponse> getAllFollower(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        return followService.getAllFollower(
                PageRequest.of(page,size));
    }

    @PostMapping("/addFollower")
    public void test (@RequestBody FollowRequest followRequest){
        followService.saveFollower(followRequest.getFollowerRequest(), followRequest.getFollowingRequest());
    }


    @DeleteMapping("/delete/{followerUserId}")
    public void deleteByFollowerId(@PathVariable("followerUserId") Long followerUserId){
        followService.deleteByFollowerUserId(followerUserId);
    }

}
