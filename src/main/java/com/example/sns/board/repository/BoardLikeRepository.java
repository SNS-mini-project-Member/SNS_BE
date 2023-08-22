package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BoardLikeEntity;
import com.example.sns.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository <BoardLikeEntity, Long> {
    BoardLikeEntity findByUserAndBoard(User userSeq, BoardEntity boardSeq);
}
