package com.example.sns.user.service;

import com.example.sns.user.repository.UserRepository;
import com.example.sns.user.domain.request.UsersRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void insert(UsersRequest request){
        userRepository.save(request.toEntity());
    }




}
