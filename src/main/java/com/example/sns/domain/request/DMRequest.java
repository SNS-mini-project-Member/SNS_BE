package com.example.sns.domain.request;

import com.example.sns.domain.entity.DirectMessage;

public record DMRequest(Integer userSeq
        , Integer friendSeq
        , String mailContent){
    public DirectMessage toEntity(){
        return DirectMessage.builder()
                .userSeq(userSeq)
                .friendSeq(friendSeq)
                .mailContent(mailContent)
                .build();
    }

}
