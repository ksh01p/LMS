package com.example.lms.entity;
import jakarta.persistence.*;

@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String youtubeUrl;

    // ManyToOne 관계 설정 - 강의를 만든 교수
    @ManyToOne
    private User professor;

    // Getters and Setters
}
