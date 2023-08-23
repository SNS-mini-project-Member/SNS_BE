package com.example.sns.controller;

import com.example.sns.domain.request.DMRequest;
import com.example.sns.service.DMService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/directmessage")
public class DMController {
    private final DMService service;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(
            @RequestBody DMRequest request){
        service.insert(request);
    }

}
