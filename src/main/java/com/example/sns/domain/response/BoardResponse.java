package com.example.sns.domain.response;

import com.example.sns.domain.entity.*;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter
public class BoardResponse  {
    private Long boardSeq;
    private String contents;
    private List<CommentDto> comment;
    private String media;
    private LocalDateTime createdAt;
    private Integer likeCount;
    private UserBoardDto userBoards;
    private List<BookDto> book;
    private List<BoardLikeDto> boardLikeEntityList;


    public BoardResponse(BoardEntity boardEntity) {
        this.boardSeq = boardEntity.getBoardSeq();
        this.contents = boardEntity.getContents();
        this.media = boardEntity.getMedia();
        this.createdAt = boardEntity.getCreatedAt();
        this.likeCount = boardEntity.getLikeCount();
        this.userBoards = new UserBoardDto(boardEntity.getUser());
        this.comment = boardEntity.getCommentEntities().stream().map(CommentDto::new).toList();
        this.book = boardEntity.getBookmarkEntities().stream().map(BookDto::new).toList();
        this.boardLikeEntityList = boardEntity.getBoardLikeEntities().stream().map(BoardLikeDto::new).toList();
    }

    @Getter
    class UserBoardDto{
        private Long UserSeq;
        private String userEmail;
        private String userName;
        private String userPhone;
        private String userAge;
        private Integer followersCount;
        private Integer followingsCount;
        private LocalDateTime createdAt;

        public UserBoardDto(User user) {
            this.UserSeq = user.getUserSeq();
            this.userEmail = user.getUserEmail();
            this.userName = user.getUserName();
            this.userPhone = user.getUserPhone();
            this.userAge = user.getUserAge();
            this.followersCount = user.getFollowersCount();
            this.followingsCount = user.getFollowingsCount();
            this.createdAt = user.getCreatedAt();
        }
    }

    @Getter
    class CommentDto {
        private Long commentSeq;
        private String userName;
        private String comment;
        private LocalDateTime createdAt;
        private List<ReCommentDto> reCommentEntity;

        public CommentDto(CommentEntity commentEntity) {
            this.commentSeq = commentEntity.getCommentSeq();
            this.userName = commentEntity.getUser().getUserName();
            this.comment = commentEntity.getComment();
            this.createdAt = commentEntity.getCreatedAt();
            this.reCommentEntity = commentEntity.getReCommentEntity().stream().map(ReCommentDto::new).toList();
        }
    }

    @Getter
    class ReCommentDto {
        private Long ReCommentSeq;
        private String reComment;
        private LocalDateTime createdAt;
        private String userName;
        private Long commentSeq;

        public ReCommentDto(ReCommentEntity reCommentEntity) {
            this.ReCommentSeq = reCommentEntity.getReCommentSeq();
            this.reComment = reCommentEntity.getReComment();
            this.createdAt = reCommentEntity.getCreatedAt();
            this.userName = reCommentEntity.getUser().getUserName();
            this.commentSeq = reCommentEntity.getComment().getCommentSeq();
        }
    }

    @Getter
    class BookDto {
        private  Long bookMarkSeq;
        private  Long boardSeq;
        private  String userName;

        public BookDto(BookmarkEntity bookmarkEntity) {
            this.bookMarkSeq = bookmarkEntity.getBookMarkSeq();
            this.boardSeq = bookmarkEntity.getBoard().getBoardSeq();
            this.userName = bookmarkEntity.getUser().getUserName();
        }
    }

    @Getter
    class BoardLikeDto {
        private Long boardLikeDto;
        private String userName;
        private Long boardSeq;

        public BoardLikeDto(BoardLikeEntity boardLikeEntity) {
            this.boardLikeDto = boardLikeEntity.getBoardLikeSeq();
            this.userName = boardLikeEntity.getUser().getUserName();
            this.boardSeq = boardLikeEntity.getBoard().getBoardSeq();
        }
    }
}

