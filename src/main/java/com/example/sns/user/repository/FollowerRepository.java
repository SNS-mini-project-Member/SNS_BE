package com.example.sns.user.repository;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.User;
import com.example.sns.user.domain.response.GetAllFollowerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Modifying;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

    import java.util.Optional;

    @Repository
    public interface FollowerRepository extends JpaRepository<Follower, Long> {


        @Query("SELECT CASE WHEN COUNT(fl) > 0 THEN true ELSE false END FROM Follower fl WHERE fl.followerUserId = :followerUserId AND fl.userId = :userId")
        boolean existsByFollowerUserIdAndUserId(@Param("followerUserId") Long followerUserId, @Param("userId") Long userId);

        @Query("SELECT CASE WHEN COUNT(fl) > 0 THEN true ELSE false END FROM Follower fl WHERE fl.followerUserId = :followerUserId")
        boolean existsByFollowerUserId(@Param("followerUserId") Long followerUserId);


        @Query("SELECT fl FROM Follower fl WHERE fl.userId = :userId")
        public Page<Follower> findFollowerBy(@Param("userId") Long userId, PageRequest pageRequest);


        @Query("SELECT f FROM Follower f " +
                "WHERE f.followersSeq = :userId ")
        public Optional<Follower> findByCheck(@Param("userId") Long userId);


        @Modifying
        @Query("DELETE FROM Follower f WHERE f.followerUserId = :followerUserId")
        public void deleteByFollowerUserId(@Param("followerUserId") Long followerUserId);

    }
