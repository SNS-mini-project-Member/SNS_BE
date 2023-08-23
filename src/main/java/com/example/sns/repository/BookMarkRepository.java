package com.example.sns.repository;

import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookmarkEntity, Long> {

    BookmarkEntity findByBoard(BoardEntity boardSeq);
}
