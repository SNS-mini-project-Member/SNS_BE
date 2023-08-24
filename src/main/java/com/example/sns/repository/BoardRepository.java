package com.example.sns.repository;

import com.example.sns.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository
        extends JpaRepository<BoardEntity, Long> {



}
//쿼리에서 like
