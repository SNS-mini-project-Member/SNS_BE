package com.example.sns.board.store;

import com.example.sns.domain.entity.BoardEntity;
import com.example.sns.domain.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "User_board")
public class UserBoard {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userBoardId;
    @ManyToOne
    private User user;
    @ManyToOne
    private BoardEntity board;
}
