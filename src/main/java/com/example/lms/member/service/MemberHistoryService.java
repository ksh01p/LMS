package com.example.lms.member.service;

import com.example.lms.admin.dto.MemberHistoryDto;

import java.util.List;

public interface MemberHistoryService {
    List<MemberHistoryDto> list(String userId);
    void saveLoginHistory(String userId, String userAgent, String clientIp);
}
