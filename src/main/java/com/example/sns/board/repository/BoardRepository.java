package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository
        extends JpaRepository<BoardEntity, Long> {

}
//쿼리에서 like
