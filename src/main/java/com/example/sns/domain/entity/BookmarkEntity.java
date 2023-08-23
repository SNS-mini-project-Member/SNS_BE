package com.example.sns.domain.entity;

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

    @ManyToOne
    @JoinColumn(name = "userSeq")
    private User user;

}

