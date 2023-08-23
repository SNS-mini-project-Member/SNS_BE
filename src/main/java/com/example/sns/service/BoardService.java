package com.example.sns.service;

import com.example.sns.domain.entity.*;
import com.example.sns.domain.request.*;
import com.example.sns.domain.response.BoardResponse;
import com.example.sns.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class BoardService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final ReCommentRepository reCommentRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final CommentLikeRepository commentLikeRepository;

    public void boardInsert(BoardRequest boardRequest) {
        BoardEntity boardEntity = boardRequest.toEntity();
        boardRepository.save(boardEntity);
    }

    public BoardResponse findById(Long userSeq){
        Optional<BoardEntity> byId = boardRepository.findById(userSeq);
        BoardEntity boardEntity = byId.orElseThrow(()->
                new RuntimeException("Not Found User by" +userSeq));
        return new BoardResponse(boardEntity);
    }

    public Page<BoardResponse> boardAll(Long userSeq, PageRequest request){
        Page<BoardEntity> all = boardRepository
                .findAllByBoardSeqContaining(userSeq, request);
        return all.map(BoardResponse::new);
    }





    public void commentInsert(CommentRequest commentRequest) {
        CommentEntity commentEntity = commentRequest.toEntity();
        commentRepository.save(commentEntity);

    }

    public void reCommentInsert(ReCommentRequest reCommentRequest) {
        ReCommentEntity reCommentEntity = reCommentRequest.toEntity();
        reCommentRepository.save(reCommentEntity);
    }









    public void boardLikes(BoardLikeRequest boardLikeRequest) {
        Long userSeq = boardLikeRequest.userSeq();
        Long boardSeq = boardLikeRequest.boardSeq();

        BoardLikeEntity existingLike =
                boardLikeRepository.findByUserAndBoard(
                        User.builder().userSeq(userSeq).build()
                        , BoardEntity.builder().boardSeq(boardSeq).build());

        if (existingLike != null) {
            // 이미 좋아요 누른 경우와 해당 데이터 삭제
            boardLikeRepository.delete(existingLike);
            BoardEntity boardEntity = boardRepository.findById(existingLike.getBoard().getBoardSeq()).get();
            boardEntity.setLikeCount(boardEntity.getLikeCount() - 1);
        } else {
            // 좋아요를 안 누른 경우
            BoardLikeEntity newLike = boardLikeRequest.toEntity();
            boardLikeRepository.save(newLike);
            BoardEntity boardEntity = boardRepository.findById(newLike.getBoard().getBoardSeq()).get();
            boardEntity.setLikeCount(boardEntity.getLikeCount() + 1);
        }
    }









    public void commentLikes(CommentLikeRequest commentLikeRequest) {
        Long userSeq = commentLikeRequest.userSeq();
        Long boardSeq = commentLikeRequest.boardSeq();
        Long commentSeq = commentLikeRequest.commentSeq();

        CommentLikeEntity existingLike =
                commentLikeRepository.findByUserAndBoardAndComment(
                        User.builder().userSeq(userSeq).build()
                        , BoardEntity.builder().boardSeq(boardSeq).build()
                        , CommentEntity.builder().commentSeq(commentSeq).build());

        if (existingLike != null){
            commentLikeRepository.delete(existingLike);
            CommentEntity commentEntity = commentRepository.findById(existingLike.getBoard().getBoardSeq()).get();
            commentEntity.setLikeCount(commentEntity.getLikeCount() -1);
        } else {
            CommentLikeEntity newLike = commentLikeRequest.toEntity();
            commentLikeRepository.save(newLike);
            CommentEntity commentEntity = commentRepository.findById(newLike.getBoard().getBoardSeq()).get();
            commentEntity.setLikeCount(commentEntity.getLikeCount() +1);
        }
    }
}