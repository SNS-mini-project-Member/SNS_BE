package com.example.sns.user.controller;

import com.example.sns.user.domain.request.UsersRequest;
import com.example.sns.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@Slf4j
public class UserController {
    private final UserService service;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(
            @RequestBody UsersRequest usersRequest){
        service.insert(usersRequest);
    }

}
