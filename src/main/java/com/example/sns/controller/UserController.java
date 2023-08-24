package com.example.sns.controller;

import com.example.sns.domain.request.LoginRequest;
import com.example.sns.domain.request.SignupRequest;
import com.example.sns.domain.request.TokenRequest;
import com.example.sns.domain.request.UpdateRequest;
import com.example.sns.domain.response.LoginResponse;
import com.example.sns.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(
            @RequestBody SignupRequest signupRequest){
        userService.signup(signupRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request, HttpServletResponse response){
        return userService.login(request, response);
    }

    @PostMapping("/update")
    public void update(@RequestBody UpdateRequest updateRequest){
        userService.Update(updateRequest.email(), updateRequest.password());
    }

    @PostMapping("/validToken")
    public String validToken(@RequestBody TokenRequest token, HttpServletResponse response) {
        return userService.validateAndRefreshToken(token, response);
    }


}
