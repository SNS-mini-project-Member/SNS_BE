package com.example.sns.domain.condition;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class UserCondition {
    private Long userSeq;
    private String userEmail;
    private String userName;
    private Integer userAge;

}
