package com.example.sns.dto;
import com.example.sns.domain.entity.BoardEntity;
import lombok.Getter;

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


