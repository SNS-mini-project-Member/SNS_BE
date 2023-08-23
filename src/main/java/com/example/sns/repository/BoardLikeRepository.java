package com.example.sns.repository;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.BoardLikeEntity;
import com.example.sns.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository <BoardLikeEntity, Long> {
    BoardLikeEntity findByUserAndBoard(User userSeq, BoardEntity boardSeq);
}
