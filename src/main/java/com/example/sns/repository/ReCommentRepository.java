package com.example.sns.repository;

import com.example.sns.domain.entity.ReCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReCommentRepository extends JpaRepository<ReCommentEntity, Long> {
}
