package com.example.sns.controller;

import com.example.sns.domain.request.FollowRequest;
import com.example.sns.domain.response.GetAllFollowerResponse;
import com.example.sns.service.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow")
@Slf4j
@CrossOrigin("*")
public class FollowController {

    private final FollowService followService;

    @GetMapping
    public Page<GetAllFollowerResponse> getAllFollowers(
            @RequestParam(value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "100") Integer size

    ){  Long userId = 11L;
        Page<GetAllFollowerResponse> allFollower = followService.getAllFollowers(PageRequest.of(page, size), userId);
        return allFollower;
    }

    @PostMapping("/addFollower")
    public void test (@RequestBody FollowRequest followRequest){
        followService.saveFollower(followRequest);
    }


    @DeleteMapping("/delete/{followerUserId}")
    public void deleteByFollowerId(@PathVariable("followerUserId") Long followerUserId){
        followService.deleteByFollowerUserId(followerUserId);
    }

}
