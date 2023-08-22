package com.example.sns.user.domain.dto;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.FriendShip;
import com.example.sns.user.domain.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userName;
    private Integer userAge;
    public UserDto(User user){
        this.userId = user.getUserId();
        this.userEmail = user.getUserEmail();
        this.userName = user.getUserName();
        this.userAge = user.getUserAge();
    }

    public UserDto(FriendShip friendShip){
        this.userId = friendShip.getUserId();
    }

    public UserDto(Follower follower){
        this.userId = follower.getUserId();
    }

    public UserDto(){

    }
}
