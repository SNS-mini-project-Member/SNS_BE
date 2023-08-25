package com.example.sns.repository;
import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.BoardLikeEntity;
import com.example.sns.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardLikeRepository extends JpaRepository <BoardLikeEntity, Long> {

    BoardLikeEntity findByUserAndBoard(User userSeq, BoardEntity boardSeq);

    @Query("select b from BoardLikeEntity b where b.user=:userSeq and b.board=:boardSeq")
    Optional<BoardLikeEntity> findByUser_UserSeqAndBoard_BoardSeq(User userSeq, BoardEntity boardSeq);

    @Query("select b.boardLikeSeq from BoardLikeEntity b where b.user=:userSeq and b.board=:boardSeq")
    Long findBySeq(User userSeq, BoardEntity boardSeq);


}
