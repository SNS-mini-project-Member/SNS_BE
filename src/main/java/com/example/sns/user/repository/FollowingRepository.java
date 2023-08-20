package com.example.sns.user.repository;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowingRepository extends JpaRepository<Follower, Long> {


    @Modifying
    @Query("DELETE FROM Follower f WHERE f.followerUserId = :followerUserId")
    public void deleteByFollowerUserId(@Param("followerUserId") Long followerUserId);

}
