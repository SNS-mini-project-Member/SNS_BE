package com.example.sns.board.domain.dto;

import com.example.sns.board.domain.entity.BoardEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
public class BoardDto {
    private Long boardSeq;
    private String contents;
    private String media;
    private Timestamp createdAt;
    private Integer likeCount;

    public BoardDto(BoardEntity boardEntity) {
        this.boardSeq = boardEntity.getBoardSeq();
        this.contents = boardEntity.getContents();
        this.media = boardEntity.getMedia();
        this.createdAt = boardEntity.getCreatedAt();
        this.likeCount = boardEntity.getLikeCount();
    }
}


