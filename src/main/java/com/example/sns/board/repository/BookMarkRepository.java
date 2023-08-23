package com.example.sns.board.repository;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookmarkEntity, Long> {

    BookmarkEntity findByBoard(BoardEntity boardSeq);
}
