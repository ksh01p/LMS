package com.example.lms.member.repository;

import com.example.lms.member.entity.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Long> {
    List<MemberHistory> findByUserId(String userId);
    Long countByUserId(String userId); //카운트
}
