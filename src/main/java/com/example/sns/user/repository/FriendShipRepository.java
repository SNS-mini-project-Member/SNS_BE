package com.example.sns.user.repository;

import com.example.sns.user.domain.entity.Follower;
import com.example.sns.user.domain.entity.FriendShip;
import com.example.sns.user.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendShipRepository extends JpaRepository<FriendShip,Long> {

    @Query("SELECT CASE WHEN COUNT(f) > 0 THEN true ELSE false END FROM FriendShip f WHERE (f.userId = :userId1 AND f.friendshipsId = :userId2) OR (f.userId = :userId2 AND f.friendshipsId = :userId1)")
    boolean existsByUserIdAndFriendshipsId(@Param("userId1") Long userId1, @Param("userId2") Long userId2);

    @Query("SELECT fs FROM FriendShip fs WHERE fs.friendshipsId = :userId")
    public Page<FriendShip> findFriendBy(@Param("userId") Long userId, PageRequest pageRequest);

    @Query("SELECT u FROM FriendShip fs INNER JOIN User u ON fs.friendshipsId =u.userId WHERE fs.userId = :userId")
    public Page<User> findAllFriend(@Param("userId") Long userId, PageRequest pageRequest);

    @Query("SELECT f FROM FriendShip f " +
            "WHERE f.friendShipSeq = :userId ")
    public Optional<FriendShip> findByCheck(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM FriendShip f WHERE f.friendshipsId = :friendId")
    public void deleteByFriendId(@Param("friendId") Long friendId);

}
