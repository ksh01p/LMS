package com.example.lms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/index")
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // templates/login.html
    }

    @GetMapping("/list")
    public String list() {
        return "list"; // templates/list.html
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload"; // templates/upload.html
    }

    @GetMapping("/announcement")
    public String announcement() {
        return "announcement"; // templates/announcement.html
    }

    @GetMapping("/assignment")
    public String assignment() {
        return "assignment"; // templates/assignment.html
    }
}
