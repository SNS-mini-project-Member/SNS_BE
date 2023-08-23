package com.example.sns.board.domain.reponse;


import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.board.domain.entity.BookmarkEntity;
import com.example.sns.user.domain.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BookMarkResponse {
    private Long bookMarkSeq;
    private Long boardSeq;
    private UserBookDto user;

    public BookMarkResponse(BookmarkEntity bookmarkEntity) {
        this.bookMarkSeq = bookmarkEntity.getBookMarkSeq();
        this.boardSeq = bookmarkEntity.getBoard().getBoardSeq();
        this.user = new UserBookDto(bookmarkEntity.getUser());
    }


    @Getter
    class UserBookDto {
        private Long UserSeq;
        private String userEmail;
        private String userName;
        private String userPhone;
        private Integer userAge;
        private Integer followersCount;
        private Integer followingsCount;
        private Timestamp createdAt;

        public UserBookDto(User user) {
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