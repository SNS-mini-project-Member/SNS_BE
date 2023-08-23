package com.example.sns.user.domain.response;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.FriendShip;
import com.example.sns.user.domain.entity.User;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class GetAllFollowerResponse {

    private Long userId;
    private String followerEmail;
    private String followerName;
    private Integer followerAge;
    private Boolean friend;
    private Date createAt;

    public GetAllFollowerResponse(User user, Follower follower, Boolean friendShip, Date createAt) {
        this.userId = user.getUserId();
        this.followerEmail = user.getUserEmail();
        this.followerName = user.getUserName();
        this.followerAge = user.getUserAge();
        this.friend = friendShip != null;
        this.createAt = createAt;
    }
}

