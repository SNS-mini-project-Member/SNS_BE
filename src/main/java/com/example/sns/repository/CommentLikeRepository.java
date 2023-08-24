package com.example.sns.repository;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.CommentEntity;
import com.example.sns.domain.entity.CommentLikeEntity;
import com.example.sns.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLikeEntity, Long> {
    CommentLikeEntity findByUserAndBoardAndComment(User userSeq, BoardEntity boardSeq, CommentEntity commentSeq);

}
