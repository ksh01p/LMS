package com.example.lms.main.controller;


import com.example.lms.admin.dto.BannerDto;
import com.example.lms.admin.model.BannerParam;
import com.example.lms.admin.service.BannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MainController {

    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model, BannerParam parameter) {

        List<BannerDto> bannerDtoList = bannerService.showList(parameter);
        model.addAttribute("list", bannerDtoList);

        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {
        
        return "error/denied";
    }

}
