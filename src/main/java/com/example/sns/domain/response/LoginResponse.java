package com.example.sns.domain.response;

import java.time.LocalDateTime;

public record LoginResponse (String email
        , String name
        , String age
        , String phone
        , Integer followersCount
        , Integer followingsCount
        , LocalDateTime createAt
        , String token
        , String refreshToken){
}

// 나중에 필요한거 가져가면된다