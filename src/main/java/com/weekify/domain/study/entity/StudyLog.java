package com.weekify.domain.study.entity;

import com.weekify.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "study_log")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class StudyLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user_id;

    @Column(name = "study_date")
    private LocalDate studyDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "study_hours")
    private Integer studyHours;

    @CreatedDate @Column(name = "created_at")
    private LocalDateTime createdAt;
}
