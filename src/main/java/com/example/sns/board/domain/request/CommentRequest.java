package com.example.sns.board.domain.request;

import com.example.sns.board.domain.entity.BoardEntity;
import com.example.sns.user.domain.entity.User;

public record CommentRequest(User user, BoardEntity board) {
}
