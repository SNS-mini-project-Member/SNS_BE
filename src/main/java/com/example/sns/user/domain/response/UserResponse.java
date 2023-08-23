package com.example.sns.user.domain.response;

import com.example.sns.user.domain.dto.UserDto;
import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.FriendShip;
import com.example.sns.user.domain.entity.User;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse extends UserDto{



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
