package com.example.lms.member.service.impl;

import com.example.lms.admin.dto.MemberHistoryDto;
import com.example.lms.member.entity.MemberHistory;
import com.example.lms.member.repository.MemberHistoryRepository;
import com.example.lms.member.service.MemberHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberHistoryServiceImpl implements MemberHistoryService {
    private final MemberHistoryRepository memberHistoryRepository;

    @Override
    public List<MemberHistoryDto> list(String userId) {
        long totalCount = this.memberHistoryRepository.countByUserId(userId);

        List<MemberHistory> historyList
                = this.memberHistoryRepository.findByUserId(userId);

        List<MemberHistoryDto> dtoList = new ArrayList<>();
        for (MemberHistory history : historyList) {
            dtoList.add(MemberHistoryDto.of(history));
        }

        if (!CollectionUtils.isEmpty(historyList)) {
            int i = 0;

            for(MemberHistoryDto x : dtoList) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - i);
                i++;
            }
        }

        return dtoList;
    }

    @Override
    public void saveLoginHistory(String userId, String userAgent, String clientIp) {
        this.memberHistoryRepository.save(MemberHistory.builder()
                .userId(userId)
                .agent(userAgent)
                .ip(clientIp)
                .logDt(LocalDateTime.now())
                .build());
    }
}
