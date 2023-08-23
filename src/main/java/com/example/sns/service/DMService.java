package com.example.sns.service;

import com.example.sns.domain.request.DMRequest;
import com.example.sns.repository.DMRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DMService {
    private final DMRepository dmRepository;


    public void insert(DMRequest request){
        dmRepository.save(request.toEntity());
    }




}