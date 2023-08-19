package com.example.sns.repository;

import com.example.sns.domain.entity.DirectMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DMRepository extends JpaRepository<DirectMessage, Integer> {
}
