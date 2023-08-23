package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BookmarkEntity;
import com.example.sns.user.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookmarkEntity, Long> {

    BookmarkEntity findByUserAndBoard(User userSeq, BoardEntity boardSeq);
    Page<BookmarkEntity> findByUser_UserSeq(Long userSeq, Pageable pageable);

    Page<BookmarkEntity> findByBoard_BoardSeq(Long boardSeq,Pageable pageable);
}
