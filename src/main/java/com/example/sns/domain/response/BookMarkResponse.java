package com.example.sns.domain.response;


import com.example.sns.domain.entity.BookmarkEntity;
import com.example.sns.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
        private Long userSeq;
        private String userEmail;
        private String userName;
        private String userPhone;
        private String userAge;
        private Integer followersCount;
        private Integer followingsCount;
        private LocalDateTime createdAt;

        public UserBookDto(User user) {


            this.userSeq = user.getUserSeq();
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