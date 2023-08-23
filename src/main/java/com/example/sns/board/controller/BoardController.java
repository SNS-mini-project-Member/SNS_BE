package com.example.sns.board.controller;

import com.example.sns.board.domain.reponse.BoardResponse;
import com.example.sns.board.domain.reponse.BookMarkResponse;
import com.example.sns.board.domain.request.*;
import com.example.sns.board.repository.ReCommentRepository;
import com.example.sns.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.query.PartTreeJpaQuery;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")

public class BoardController {
    private final BoardService boardService;


    @PostMapping("/boards")// 게시물 작성 v
    @ResponseStatus(HttpStatus.CREATED)
    public void boardInsert(@RequestBody BoardRequest request) {
        boardService.boardInsert(request);
    }


    @PostMapping("/comment")// 댓글 작성 v
    @ResponseStatus(HttpStatus.CREATED)
    public void commentsInsert(@RequestBody CommentRequest request) {
        boardService.commentInsert(request);
    }

    @PostMapping("/recomment") // 대댓글 작성 v
    @ResponseStatus(HttpStatus.CREATED)
    public void reCommentsInsert(@RequestBody ReCommentRequest request) {
        boardService.reCommentInsert(request);
    }

    @PostMapping("/likes") // 좋아요 v
    @ResponseStatus(HttpStatus.CREATED)
    public void boardLikePost(@RequestBody BoardLikeRequest request) {
        boardService.boardLikes(request);
    }

    @PostMapping("/commentlikes") // 댓글 좋아요 v
    @ResponseStatus(HttpStatus.CREATED)
    public void commentLikePost(@RequestBody CommentLikeRequest request) {
        boardService.commentLikes(request);
    }

    @PostMapping("/book") // 북마크 추가 v
    @ResponseStatus(HttpStatus.CREATED)
    public void bookMarkPost(@RequestBody BookMarkRequest request) {
        boardService.bookMark(request);
    }

    @GetMapping("/board/{id}") // 게시물 검색하면 유저에 대한 정보 v
    public BoardResponse getById(@PathVariable("id") Long userSeq) {
        return boardService.findByUserSeq(userSeq);
    }


    @GetMapping("/userBook/{userSeq}")// 유저가 즐겨찾기한 정보 ???
    public Page<BookMarkResponse> getByBookUserSeqAll(
            @RequestParam(name = "userSeq",
                    required = false,
                    defaultValue = "") Long userSeq,
            @RequestParam(name = "size",
                    required = false,
                    defaultValue = "10") Integer size,
            @RequestParam(name = "page",
                    required = false,
                    defaultValue = "0 ") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return boardService.findByBookUser(userSeq, request);
    }

    @GetMapping("/boardBook/{boardSeq}") // 게시물을 조회하면 유저 정보 v
    public Page<BookMarkResponse> getByBookSeqAll(
            @RequestParam(name = "boardSeq",
                    required = false,
                    defaultValue = "") Long BoardSeq,
            @RequestParam(name = "size",
                    required = false,
                    defaultValue = "10") Integer size,
            @RequestParam(name = "page",
                    required = false,
                    defaultValue = "0 ") Integer page
    ) {
        PageRequest request = PageRequest.of(page, size);
        return boardService.findBookSeqAll(BoardSeq, request);
    }
}