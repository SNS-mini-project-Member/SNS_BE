package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.ReCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCommentRepository extends JpaRepository<ReCommentEntity, Long> {
}
