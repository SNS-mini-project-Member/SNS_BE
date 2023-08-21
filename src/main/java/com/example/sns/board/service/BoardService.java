package com.example.sns.board.service;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.CommentEntity;
import com.example.sns.board.domain.request.BoardRequest;
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

    public BoardEntity createBoard(User user, String contents, String media, String hashTag){
        BoardEntity board = BoardEntity.builder()
                .contents(contents)
                .media(media)
                .hashTag(hashTag)
                .user(user)
                .build();

        return board;
    }

    public void boardInsert(BoardRequest boardRequest, Long user_seq){
        Optional<User> byId = userRepository.findById(user_seq);

        BoardEntity board = BoardEntity.builder()
                .user(byId.get())
                .contents(boardRequest.toEntity().getContents())
                .media(boardRequest.toEntity().getMedia())
                .hashTag(boardRequest.toEntity().getHashTag())
                .createdAt(boardRequest.toEntity().getCreatedAt())
                .build();

            boardRepository.save(board);
    }

    public void commentInsert(){

    }
}
