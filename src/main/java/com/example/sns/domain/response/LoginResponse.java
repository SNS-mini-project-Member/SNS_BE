package com.example.sns.domain.response;

import java.sql.Timestamp;

public record LoginResponse (String email
        , String name
        , Integer age
        , String phone
        , Integer followersCount
        , Integer followingsCount
        , String token){
}

// 나중에 필요한거 가져가야함