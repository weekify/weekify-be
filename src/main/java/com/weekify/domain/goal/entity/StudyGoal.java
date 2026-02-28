package com.weekify.domain.goal.entity;

import com.weekify.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Entity
@Table(name = "study_goal")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class StudyGoal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id", nullable = false)
    private User userID;

    @Column(name = "weekly_hours")
    private Integer weeklyHours;

    @Column(name = "study_days")
    private Integer studyDays;

    @Column(name = "daily_hours")
    private Integer dailyHours;

    @Column(name = "apply_month")
    private Integer applyMonth;

    @CreatedDate @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
