package com.example.sns.domain.response;
import com.example.sns.domain.entity.Follower;
import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class GetAllFollowerResponse {

    private Long userId;
    private String followerEmail;
    private String followerName;
    private String followerAge;
    private String followerPhone;
    private Boolean friend;
    private LocalDateTime createAt;

    public GetAllFollowerResponse(User user, Follower follower, Boolean friendShip, LocalDateTime createAt) {
        this.userId = user.getUserSeq();
        this.followerEmail = user.getUserEmail();
        this.followerName = user.getUserName();
        this.followerAge = user.getUserAge();
        this.friend = friendShip != null;
        this.followerPhone = user.getUserPhone();
        this.createAt = createAt;
    }
}

