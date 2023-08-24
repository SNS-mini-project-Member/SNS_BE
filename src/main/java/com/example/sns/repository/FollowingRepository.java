package com.example.sns.repository;

import com.example.sns.domain.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends JpaRepository<Following, Long> {



    @Modifying
    @Query("DELETE FROM Following f WHERE f.userId = :followerUserId")
    public void deleteByFollowerUserId(@Param("followerUserId") Long followerUserId);

}
