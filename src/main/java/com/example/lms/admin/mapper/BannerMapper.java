package com.example.lms.admin.mapper;


import com.example.lms.admin.dto.BannerDto;
import com.example.lms.admin.model.BannerParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    long selectListCount(BannerParam parameter);
    List<BannerDto> selectList(BannerParam parameter);
    List<BannerDto> selectShowList(BannerParam parameter);
}
