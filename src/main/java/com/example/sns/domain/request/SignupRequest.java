package com.example.sns.domain.request;


import com.example.sns.domain.entity.User;

public record SignupRequest(String email
        , String password
        , String name
        , String age
        , String phone){
    public User toEntity(){
        return User.builder()
                .userEmail(email)
                .userPassword(password)
                .userName(name)
                .userAge(age)
                .userPhone(phone)
                .build();
    }

}
