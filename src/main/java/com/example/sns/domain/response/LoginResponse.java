package com.example.sns.domain.response;

import java.sql.Timestamp;

public record LoginResponse (String email
        , String name
        , String age
        , String phone
        , Integer followersCount
        , Integer followingsCount
        , Timestamp createAt
        , String token){
}

// 나중에 필요한거 가져가면된다