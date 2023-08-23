package com.example.sns.board.domain.entity;

import com.example.sns.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookMark")
public class BookmarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookMarkSeq;

    @ManyToOne
    @JoinColumn(name = "boardSeq")
    private BoardEntity board;

}

