package com.example.sns.board.service;

import com.example.sns.board.domain.entity.*;

import com.example.sns.board.domain.request.*;
import com.example.sns.board.repository.*;
import com.example.sns.user.domain.entity.User;
import com.example.sns.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

        if (existingLike != null){
            // 이미 좋아요 누른 경우와 해당 데이터 삭제
            boardLikeRepository.delete(existingLike);
        }else {
            // 좋아요를 안 누른 경우
            BoardLikeEntity newLike = boardLikeRequest.toEntity();
            boardLikeRepository.save(newLike);
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
        } else {
            CommentLikeEntity newLike = commentLikeRequest.toEntity();
            commentLikeRepository.save(newLike);
        }
    }
}

