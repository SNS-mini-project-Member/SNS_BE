package com.example.sns.board.service;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import com.example.sns.board.domain.entity.ReCommentEntity;
import com.example.sns.board.domain.request.BoardRequest;
import com.example.sns.board.domain.request.CommentRequest;
import com.example.sns.board.domain.request.ReCommentRequest;
import com.example.sns.board.repository.BoardRepository;
import com.example.sns.board.repository.CommentRepository;
import com.example.sns.user.domain.entity.User;
import com.example.sns.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class BoardService {
    private final EntityManager em;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public void boardInsert(BoardRequest boardRequest) {
        BoardEntity boardEntity = boardRequest.toEntity();
        boardRepository.save(boardEntity);
    }

    public void commentInsert(CommentRequest commentRequest) {
        CommentEntity commentEntity = commentRequest.toEntity();
        commentRepository.save(commentEntity);
//        Optional<User> userId = userRepository.findById(user_seq);
//        Optional<BoardEntity> commentId = boardRepository.findById(board_seq);

//        CommentEntity comment = CommentEntity.builder()
//                .user(userId.get())
//                .board(commentId.get())
//                .comment(commentRequest.toEntity().getComment())
//                .likeCount(commentRequest.toEntity().getLikeCount())
//                .createdAt(commentRequest.toEntity().getCreatedAt())
//                .build();
    }
    public void ReCommentInsert(ReCommentRequest reCommentRequest) {

    }
}