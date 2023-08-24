package com.example.sns.repository;

import com.example.sns.domain.entity.ReCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReCommentRepository extends JpaRepository<ReCommentEntity, Long> {
    List<ReCommentEntity> findByComment_Board_BoardSeq(Long boardSeq);
}
