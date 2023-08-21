package com.example.sns.domain.response;

public record LoginResponse (String name
        , Integer age
        , String phone
        , Integer followersCount
        , Integer followingsCount
        , String token){
}

// 나중에 필요한거 가져가면된다