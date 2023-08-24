package com.example.sns.domain.request;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.CommentEntity;
import com.example.sns.domain.entity.CommentLikeEntity;
import com.example.sns.domain.entity.User;

public record CommentLikeRequest(Long userSeq
        , Long boardSeq
        , Long commentSeq) {
    public CommentLikeEntity toEntity(){
        return CommentLikeEntity.builder()
                .user(User.builder().userSeq(userSeq).build())
                .board(BoardEntity.builder().boardSeq(boardSeq).build())
                .comment(CommentEntity.builder().commentSeq(commentSeq).build())
                .build();
    }
}
