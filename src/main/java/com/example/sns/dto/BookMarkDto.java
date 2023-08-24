package com.example.sns.dto;

import com.example.sns.domain.entity.BoardEntity;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class BookMarkDto {

    private Long boardSeq;

    private String contents;

    private String media;

    private LocalDateTime createdAt;

    public BookMarkDto(Long boardSeq, String contents, String media, LocalDateTime createdAt) {
        this.boardSeq = boardSeq;
        this.contents = contents;
        this.media = media;
        this.createdAt = createdAt;
    }

    public BookMarkDto(BoardEntity board) {
        this.boardSeq = board.getBoardSeq();
        this.contents = board.getContents();
        this.media = board.getMedia();
        this.createdAt = board.getCreatedAt();
    }
}