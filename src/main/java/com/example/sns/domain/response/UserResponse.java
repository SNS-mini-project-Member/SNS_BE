package com.example.sns.domain.response;

import com.example.sns.domain.entity.Follower;
import com.example.sns.domain.entity.FriendShip;
import com.example.sns.domain.entity.User;
import com.example.sns.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse extends UserDto {



    public UserResponse(User user) {
        super(user);
    }

    public UserResponse(){
        super();
    }

    public UserResponse(FriendShip friendShip){
        super(friendShip);
    }

    public UserResponse(Follower follower){
        super(follower);
    }

}
