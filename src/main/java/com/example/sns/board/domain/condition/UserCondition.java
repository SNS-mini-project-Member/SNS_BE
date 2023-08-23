package com.example.sns.board.domain.condition;

import jakarta.persistence.Column;
import lombok.*;

import java.sql.Timestamp;
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
