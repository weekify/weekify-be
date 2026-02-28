package com.weekify.domain.group.entity;

import com.weekify.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "group_member",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_group_member_user_id_group_id", columnNames = {"user_id", "group_id"})
    }
)
@Getter
@NoArgsConstructor
public class GroupMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "group_id")
    private StudyGroup studyGroup;

    @Column(name = "join_at" , nullable = false)
    private LocalDate joinAt;
}
