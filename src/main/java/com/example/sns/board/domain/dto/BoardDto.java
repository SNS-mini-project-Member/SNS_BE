package com.example.sns.board.domain.dto;

import com.example.sns.board.domain.entity.BoardEntity;
import lombok.Getter;
import java.sql.Timestamp;

@Getter
public class BoardDto {

    private Long boardSeq;

    private String contents;

    private String media;

    private String hashTag;

    private Timestamp createdAt;

    public BoardDto(BoardEntity boardEntity) {
        this.boardSeq = boardEntity.getBoardSeq();
        this.contents = boardEntity.getContents();
        this.media = boardEntity.getMedia();
        this.hashTag = boardEntity.getHashTag();
        this.createdAt = boardEntity.getCreatedAt();
    }



}