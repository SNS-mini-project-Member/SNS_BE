package com.example.sns.domain.request;

import com.example.sns.domain.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EmailRequest {
    private String email;
    public EmailRequest(User user){
        this.email=user.getUserEmail();
    }

}
