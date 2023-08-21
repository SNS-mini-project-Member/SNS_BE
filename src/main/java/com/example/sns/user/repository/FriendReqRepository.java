package com.example.sns.user.repository;
import com.example.sns.user.domain.entity.FriendReq;
import com.example.sns.user.domain.request.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendReqRepository extends JpaRepository<FriendReq, Long> {

    @Query("SELECT f FROM FriendReq f " +
            "WHERE f.friendRequestsSeq= :userId ")
    public Optional<FriendRequest> findByCheck(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM FriendReq f WHERE f.requesterId = :reqId")
    public void deleteByReqId(@Param("reqId") Long reqId);

}
