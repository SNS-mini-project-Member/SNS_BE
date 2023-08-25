package com.example.sns.service;

import com.example.sns.domain.entity.*;
import com.example.sns.domain.request.*;
import com.example.sns.domain.response.BoardResponse;
import com.example.sns.domain.response.BookMarkResponse;
import com.example.sns.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    private final BookMarkRepository bookMarkRepository;

    public List<BoardResponse> findAll() {
        List<BoardEntity> all = boardRepository.findAll();
        return all.stream().map(BoardResponse::new).toList();
    }
    public void boardInsert(BoardRequest boardRequest) {
        BoardEntity boardEntity = boardRequest.toEntity();
        boardRepository.save(boardEntity);
    }

    public BoardResponse findByUserSeq(Long userSeq) {
        Optional<BoardEntity> byId = boardRepository.findById(userSeq);

        if (byId.isPresent()) {
            BoardEntity boardEntity = byId.get();

            List<CommentEntity> byComment = commentRepository.findByBoard_BoardSeq(userSeq);
            List<ReCommentEntity> byReComment = reCommentRepository.findByComment_Board_BoardSeq(userSeq);

            boardEntity.getCommentEntities().addAll(byComment);
            boardEntity.getCommentEntities().forEach(commentEntity
                    -> commentEntity.getReCommentEntity().addAll(byReComment));

//            BoardEntity boardEntity = byId.orElseThrow(() ->
//                    new RuntimeException("Not Found User by" + userSeq));
//            return new BoardResponse(boardEntity);
            return new BoardResponse(boardEntity);
        } else {
            throw new RuntimeException("Not Found User by" + userSeq);
        }
    }
//========================
//    public BoardResponse findByCommentSeq(Long commentSeq) {
//        Optional<CommentEntity> byCommentId = commentRepository.findById(commentSeq);
//        CommentEntity commentEntity = byCommentId.orElseThrow(() ->
//                new RuntimeException("Not Found User by" + commentSeq));
//        return;
//    }

//    public Page<BoardResponse> boardAll(Long userSeq, PageRequest request){
//        Page<BoardEntity> all = boardRepository
//                .findAllByBoardSeqContaining(userSeq, request);
//        return all.map(BoardResponse::new);
//    }


    // 게시물 댓글 작성 로직 + 게시물에 댓글 작성하면 +1
    public void commentInsert(CommentRequest commentRequest) {
//        CommentEntity commentEntity = commentRequest.toEntity();
        commentRepository.save(commentRequest.toEntity());

//        Long boardSeq = commentRequest.boardSeq();
//        BoardEntity board = boardRepository.findById(boardSeq).orElse(null);
//        if (board != null) {
//            board.setCommentCount(board.getCommentCount() + 1);
//            boardRepository.save(board);
//        }

    }

    public void reCommentInsert(ReCommentRequest reCommentRequest) {
        ReCommentEntity reCommentEntity = reCommentRequest.toEntity();
        reCommentRepository.save(reCommentEntity);
    }

    public void boardLikes(BoardLikeRequest request) {
        User userSeq = User.builder().userSeq(request.userSeq()).build();
        BoardEntity boardSeq = BoardEntity.builder().boardSeq(request.boardSeq()).build();
        Optional<BoardLikeEntity> byId = boardLikeRepository.findByUser_UserSeqAndBoard_BoardSeq(userSeq, boardSeq);
        Long findId = boardLikeRepository.findBySeq(userSeq, boardSeq);


        if (!byId.isEmpty()) {
            // 이미 좋아요 누른 경우와 해당 데이터 삭제
            System.out.println("이미 있따");
            boardLikeRepository.deleteById(findId);

        } else {
            // 좋아요를 안 누른 경우
            System.out.println("없다");
            boardLikeRepository.save(request.toEntity());
        }
    }

    public void bookMark(BookMarkRequest bookMarkRequest) {
        Long userSeq = bookMarkRequest.toEntity().getUser().getUserSeq();
        Long boardSeq = bookMarkRequest.toEntity().getBoard().getBoardSeq();

        BookmarkEntity existingBook =
                bookMarkRepository.findByUserAndBoard(
                        User.builder().userSeq(userSeq).build()
                        , BoardEntity.builder().boardSeq(boardSeq).build());

        System.out.println("existingBook : "+  existingBook);

        if (existingBook != null) {
            bookMarkRepository.delete(existingBook);
            BoardEntity boardEntity = boardRepository.findById(existingBook.getBoard().getBoardSeq()).get();
            boardEntity.setBookMarkCount(boardEntity.getBookMarkCount() - 1);
        } else {
            BookmarkEntity newLike = bookMarkRequest.toEntity();
            bookMarkRepository.save(newLike);
            BoardEntity boardEntity = boardRepository.findById(newLike.getBoard().getBoardSeq()).get();
            boardEntity.setBookMarkCount(boardEntity.getBookMarkCount() + 1);
        }
    }

    // 유저가 즐겨찾기한 정보
    public Page<BookMarkResponse> findByBookUser(Long userSeq, PageRequest request) {
        Page<BookmarkEntity> byBoard = bookMarkRepository.findByUser_UserSeq(userSeq, request);
        return byBoard.map(BookMarkResponse::new);
    }
    // 게시물을 조회하면 북마크 유저 정보
    public Page<BookMarkResponse> findBookSeqAll(Long boardSeq, PageRequest request) {
        Page<BookmarkEntity> byBoard = bookMarkRepository.findByBoard_BoardSeq(boardSeq, request);
        return byBoard.map(BookMarkResponse::new);
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