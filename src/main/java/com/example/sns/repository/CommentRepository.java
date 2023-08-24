package com.example.sns.repository;

import com.example.sns.domain.entity.CommentEntity;
import com.example.sns.domain.entity.ReCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByBoard_BoardSeq(Long boardSeq);

}
