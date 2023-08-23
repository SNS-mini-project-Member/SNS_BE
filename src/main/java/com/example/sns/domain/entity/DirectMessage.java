package com.example.sns.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter @Entity
@Table(name = "DirectMessage")
public class DirectMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dMSeq;

    @Column(nullable = false, name = "user_seq")
    private Integer userSeq;

    @Column(nullable = false, name = "friend_seq")
    private Integer friendSeq;

    @Column(nullable = false, name = "created_at")
    private LocalDate createdAt;

    @Column(nullable = false, name = "mail_content")
    private String mailContent;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now(); // 생성 시 현재 시간으로 설정
    }

}
