package com.weekify.domain.user.entity;

import com.weekify.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;



import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;

    private String addrCity;
    private String addrDistrict;
    private String addrDong;

    /*
    User - UserCategory 관계에서 비주인 - "mappedBy" 속성 사용
    "user" : UserCategory 클래세으 있는 필드명
    -> 주인이 아니고 UserCategory user 필드가 주인
     */
    @OneToMany(mappedBy = "user")
    private List<UserCategory> userCategories = new ArrayList<>();
}
