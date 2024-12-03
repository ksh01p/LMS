package com.example.lms.service;

import com.example.lms.entity.Lecture;
import com.example.lms.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    @Autowired
    private LectureRepository lectureRepository;

    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    public Lecture addLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }
}
