package com.example.sns.board.domain.condition;

import lombok.*;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BoardCondition {
    private Long boardSeq;
    private String contents;
    private String media;
    private Timestamp createdAt;
    private Integer likeCount;
}
