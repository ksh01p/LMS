package com.example.lms.entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDate createdDate;

    // Getters and Setters
}
