package com.example.sns.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class CommentResponse {
    private Long userSeq;
    private Long boardSeq;
    private String comment;

}
