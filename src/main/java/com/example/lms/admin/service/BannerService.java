package com.example.lms.admin.service;

import com.example.lms.admin.dto.BannerDto;
import com.example.lms.admin.model.BannerInput;
import com.example.lms.admin.model.BannerParam;

import java.util.List;

public interface BannerService {

    List<BannerDto> list(BannerParam parameter);

    boolean add(BannerInput parameter);

    /**
     * 배너 상세 정보
     */
    BannerDto getById(long id);

    /**
     * 배너 정보 수정
     */
    boolean set(BannerInput parameter);

    /**
     * 배너 내용 삭제
     */
    boolean del(String idList);

    /**
     * 프론트 카테고리 정보
     */
    List<BannerDto> showList(BannerParam parameter);

}
