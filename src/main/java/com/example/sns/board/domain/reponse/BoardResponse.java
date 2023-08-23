package com.example.sns.board.domain.reponse;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.user.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter
public class BoardResponse  {
    private Long boardSeq;
    private String contents;
    private String media;
    private Timestamp createdAt;
    private Integer likeCount;
    private UserBoardDto userBoards;

    public BoardResponse(BoardEntity boardEntity) {
        this.boardSeq = boardEntity.getBoardSeq();
        this.contents = boardEntity.getContents();
        this.media = boardEntity.getMedia();
        this.createdAt = boardEntity.getCreatedAt();
        this.likeCount = boardEntity.getLikeCount();
        this.userBoards = new UserBoardDto(boardEntity.getUser());
    }

    @Getter
    class UserBoardDto{
        private Long UserSeq;
        private String userEmail;
        private String userName;
        private String userPhone;
        private Integer userAge;
        private Integer followersCount;
        private Integer followingsCount;
        private Timestamp createdAt;

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
}

