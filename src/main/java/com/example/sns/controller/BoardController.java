package com.example.sns.controller;

import com.example.sns.domain.request.*;
import com.example.sns.domain.response.BoardResponse;
import com.example.sns.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")

public class BoardController {
    private final BoardService boardService;


    @PostMapping("/boards")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody BoardRequest request) {
        boardService.boardInsert(request);
    }
    @GetMapping("{id}")
    public BoardResponse getById(@PathVariable("id") Long userSeq){
        return boardService.findById(userSeq);
    }

    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void comments(@RequestBody CommentRequest request) {
        boardService.commentInsert(request);
    }

    @PostMapping("/recomment")
    @ResponseStatus(HttpStatus.CREATED)
    public void reComments(@RequestBody ReCommentRequest request) {
        boardService.reCommentInsert(request);
    }

    @PostMapping("/likes")
    @ResponseStatus(HttpStatus.CREATED)
    public void boardLikePost(@RequestBody BoardLikeRequest request) {
        boardService.boardLikes(request);
    }

    @PostMapping("/commentlikes")
    @ResponseStatus(HttpStatus.CREATED)
    public void commentLikePost(@RequestBody CommentLikeRequest request) {
        boardService.commentLikes(request);
    }
}
