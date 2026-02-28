package com.weekify.domain.group.entity;

import com.weekify.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_group")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class StudyGroup {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "leader_id", nullable = false)
    private User leader;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String description;

    private Integer max;

    @Column(name = "is_public")
    private Boolean isPublic = true;

    @CreatedDate @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "studyGroup")
    private List<GroupMember> groupMembers = new ArrayList<>();
}
