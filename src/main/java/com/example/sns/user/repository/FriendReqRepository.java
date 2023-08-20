package com.example.sns.user.repository;
import com.example.sns.user.domain.entity.FriendReq;
import com.example.sns.user.domain.entity.FriendShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendReqRepository extends JpaRepository<FriendShip, Long> {

    @Modifying
    @Query("DELETE FROM FriendReq f WHERE f.friendRequestsSeq = :reqId")
    public void deleteByReqId(@Param("friendRequestsSeq") Long reqdId);

}
