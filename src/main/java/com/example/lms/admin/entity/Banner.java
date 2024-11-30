package com.example.lms.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String bannerName;  //배너명
    String bannerUrl;   //배너 링크 주소

    int openCase;   //오픈 방법
    int sortNum;    //정렬 순서
    boolean showYn; //공개 여부

    LocalDateTime regDt;

    String fileName;
    String urlFileName;
}
