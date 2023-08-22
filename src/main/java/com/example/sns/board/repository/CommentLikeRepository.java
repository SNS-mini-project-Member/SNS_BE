package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import com.example.sns.board.domain.entity.CommentLikeEntity;
import com.example.sns.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLikeEntity, Long> {
    CommentLikeEntity findByUserAndBoardAndComment(User userSeq, BoardEntity boardSeq, CommentEntity commentSeq);

}
