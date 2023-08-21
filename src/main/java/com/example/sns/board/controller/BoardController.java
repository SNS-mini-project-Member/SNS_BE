package com.example.sns.board.controller;

import com.example.sns.board.domain.request.BoardRequest;
import com.example.sns.board.domain.request.CommentRequest;
import com.example.sns.board.service.BoardService;
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
    public void insert(@RequestBody BoardRequest request){
        boardService.boardInsert(request);
    }
    @PostMapping("/comment")
    @ResponseStatus(HttpStatus.CREATED)
    public void comments(@RequestBody CommentRequest request){
        boardService.commentInsert(request);

    }


}
