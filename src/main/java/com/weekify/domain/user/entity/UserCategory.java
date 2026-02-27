package com.weekify.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "user_categories",
        /*
         "복합 유니크" : 같은 유저가 같은 카테고리 중복 선택 상황을 DB 레벨에서 설정
         두 컬럼의 조합이 동일할 때만 금지
         User Entity user_id 단독 UNIQUE -> 다대다 관계 깨짐
         Category_id 단독 UNIQUE -> 다대다 관계 깨짐
         (user_id, category_id) 복합 UNIQUE -> 원하는 중복만 방지
         */
        uniqueConstraints = @UniqueConstraint(
                name = "uk_user_categorties_user_id_category_id",
                columnNames = {"user_id", "category_id"}
        )
)
@Getter
@NoArgsConstructor
public class UserCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne @JoinColumn(name = "category_id")
    private Category category;
}
