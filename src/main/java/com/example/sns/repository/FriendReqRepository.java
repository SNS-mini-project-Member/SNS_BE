package com.example.sns.repository;
import com.example.sns.domain.entity.FriendReq;
import com.example.sns.domain.entity.User;
import com.example.sns.domain.request.FriendRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface FriendReqRepository extends JpaRepository<FriendReq, Long> {
    @Query("SELECT u FROM FriendReq fr INNER JOIN User u ON fr.requesterId = u.userSeq WHERE fr.requesteeId = :userId")
    public Page<User> findAllFriendReq(@Param("userId") Long userId, PageRequest pageRequest);

    @Query("SELECT f FROM FriendReq f " +
            "WHERE f.friendRequestsSeq= :userId ")
    public Optional<FriendRequest> findByCheck(@Param("userId") Long userId);

    @Modifying
    @Query("DELETE FROM FriendReq f WHERE f.requesterId = :reqId")
    public void deleteByReqId(@Param("reqId") Long reqId);

}
