package com.example.sns.service;

import com.example.sns.auth.AuthService;
import com.example.sns.domain.entity.User;
import com.example.sns.domain.request.LoginRequest;
import com.example.sns.domain.response.LoginResponse;
import com.example.sns.exception.LoginFailException;
import com.example.sns.repository.UserRepository;
import com.example.sns.domain.request.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthService authService;


    public void signup(SignupRequest request){
        Optional<User> byEmail = userRepository.findByEmail(request.email());
        if (byEmail.isEmpty()) {
            userRepository.save(request.toEntity());
        }
        else System.out.println("이미 존재하는 Email");
    }

    public LoginResponse login(LoginRequest request){
        Optional<User> byEmailAndPw = userRepository.findByEmailAndPassword(request.email(), request.password());
        User user = byEmailAndPw.orElseThrow(() -> new LoginFailException("해당 유저가 존재하지 않습니다.."));
        String token = authService.makeToken(user);
        return new LoginResponse(
                user.getUserEmail(),
                user.getUserName(),
                user.getUserAge(),
                user.getUserPhone(),
                user.getFollowersCount(),
                user.getFollowingsCount(),
                user.getCreatedAt(),
                token);
    }


}
