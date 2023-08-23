package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository
        extends JpaRepository<BoardEntity, Long> {
    Page<BoardEntity> findAllByBoardSeqContaining(Long userSeq, Pageable pageable);
}
//쿼리에서 like
