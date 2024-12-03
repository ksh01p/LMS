package com.example.lms.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;

    // 과제를 부여한 강의
    @ManyToOne
    private Lecture lecture;

    // 과제를 제출한 학생들 (다대다 관계)
    @ManyToMany
    private List<User> submittedStudents;

    // Getters and Setters
}
