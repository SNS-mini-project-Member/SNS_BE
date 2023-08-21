package com.example.sns.user.repository;
import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.FriendRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendRecommendRepository extends JpaRepository<FriendRecommend,Long>{

    @Query("SELECT f FROM FriendRecommend f " +
            "WHERE f.friendRecommendationsSeq = :userId ")
    public Optional<FriendRecommend> findByCheck(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM FriendRecommend f WHERE f.recommendedUserId = :recommendId")
    public void deleteByRecommendId(@Param("recommendId") Long recommendId);

}
