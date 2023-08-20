package com.example.sns.user.repository;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.FriendShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendShipRepository extends JpaRepository<FriendShip,Long> {

    @Query("SELECT f FROM FriendShip f " +
            "WHERE f.friendShipSeq = :userId ")
    public Optional<FriendShip> findByCheck(@Param("friendShipSeq") Long userId);


    @Modifying
    @Query("DELETE FROM FriendShip f WHERE f.friendShipSeq = :friendId")
    public void deleteByFriendId(@Param("friendShipSeq") Long friendId);

}
