package com.example.sns.user.repository;

import com.example.sns.user.domain.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {

    @Query("SELECT f FROM Follower f " +
            "WHERE f.followersSeq = :userId ")
    public Optional<Follower> findByCheck(@Param("userId") Long userId);


    @Modifying
    @Query("DELETE FROM Follower f WHERE f.followerUserId = :followerUserId")
    public void deleteByFollowerUserId(@Param("followerUserId") Long followerUserId);

}
