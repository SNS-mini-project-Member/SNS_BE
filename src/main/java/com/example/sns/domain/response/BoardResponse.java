package com.example.sns.domain.response;

import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter
public class BoardResponse  {
    private Long boardSeq;
    private String contents;
    private String media;
    private LocalDateTime createdAt;
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
}

