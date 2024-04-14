package com.sopt.practice2.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity // 객체와 테이블을 매핑하는 어노테이션(JPA가 관리하는 Entity)
@Getter // 전체 필드에 대한 getter 함수를 lombok이 제공
@NoArgsConstructor // 기본 생성자를 생성하도록 lombok이 제공
public class Member {
    @Id // 영속성 컨텍스트는 엔티티를 식별자 값으로 구분
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;
    private int age;

    @Builder
    public Member(String name, Part part, int age){
        this.name = name;
        this.part = part;
        this.age = age;
    }
}
