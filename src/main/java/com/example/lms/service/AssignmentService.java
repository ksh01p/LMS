package com.example.lms.service;
import com.example.lms.entity.Assignment;
import com.example.lms.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignmentsByLecture(Long lectureId) {
        return assignmentRepository.findByLectureId(lectureId);
    }
}

