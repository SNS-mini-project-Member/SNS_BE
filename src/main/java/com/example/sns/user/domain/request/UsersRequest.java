package com.example.sns.user.domain.request;


import com.example.sns.user.domain.entity.User;

public record UsersRequest(String email
        , String password
        , String name
        , Integer age){
    public User toEntity(){
        return User.builder()
                .userEmail(email)
                .userPassword(password)
                .userAge(age)
                .userName(name)
                .build();
    }

}
