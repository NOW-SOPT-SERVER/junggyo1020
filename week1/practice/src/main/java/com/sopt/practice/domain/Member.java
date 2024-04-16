package com.sopt.practice.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;

    //빌더패턴
    @Builder
    private Member(String name, Part part, int age) {
        this.name = name;
        this.part = part;
        this.age = age;
    }
    //정적 팩토리 메서드
    public static Member create(String name,Part part, int age){
        return Member.builder()
                .name(name)
                .part(part)
                .age(age)
                .build();
    }
}
