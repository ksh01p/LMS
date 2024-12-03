package com.example.lms.controller;

import com.example.lms.entity.Lecture;
import com.example.lms.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lectures")
public class LectureController {
    @Autowired
    private LectureService lectureService;

    @GetMapping
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @PostMapping("/add")
    public Lecture addLecture(@RequestBody Lecture lecture) {
        return lectureService.addLecture(lecture);
    }
}
